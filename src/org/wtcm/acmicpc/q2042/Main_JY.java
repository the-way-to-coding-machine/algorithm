package org.wtcm.acmicpc.q2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_JY {
    static int N, M, K;
    static StringTokenizer tokenizer;
    static int[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        arr = new int[N + 1];
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int treeHeight = (int) Math.ceil(log(2, N));
        int treeSize = 1 << (treeHeight + 1);
        tree = new int[treeSize + 1];

        makeSegmentTree(1, 1, N);

        for (int i = 0; i < M + K; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            if (a == 1) { // update
                int diff = c - arr[b];
                arr[b] = c;
                update(b, diff, 1, 1, N);
            } else { // prefix sum
                answer.add(prefixSum(1, b, c, 1, N));
            }
        }
        answer.forEach(System.out::println);
    }

    static int makeSegmentTree(int current, int start, int end) {
        if (start == end)
            return tree[current] = arr[start];

        int mid = (start + end) >> 1;
        return tree[current] = makeSegmentTree(current * 2, start, mid) + makeSegmentTree(current * 2 + 1, mid + 1, end);
    }

    static int prefixSum(int current, int start, int end, int left, int right) { // [left, right] -> tree의 range. [start, end] -> 구하고자 하는 구간.
        if (start > right || end < left)
            return 0;

        else if (start >= left && right <= end)
            return tree[current];

        int mid = (left + right) >> 1;
        return prefixSum(current * 2, start, mid, left, right)
                + prefixSum(current * 2 + 1, mid + 1, end, left, right);

    }

    static void update(int changedIndex, int diff, int current, int start, int end) {
        if (changedIndex < start || changedIndex > end) // 바뀐 노드가 범위 밖이면 리턴
            return;

        tree[current] += diff; // 바뀐 노드를 포함하는 노드들은 모두 증감분을 더해준다.

        if (start != end) {
            int mid = (start + end) >> 1;
            update(changedIndex, diff, current * 2, start, mid);
            update(changedIndex, diff, current * 2 + 1, mid + 1, end);
        }
    }

    static double log(int base, int num) {
        return Math.log10(num) / Math.log10(base);
    }
}
