package org.wtcm.acmicpc.q5419;

import java.util.Arrays;
import java.util.Scanner;

/* note. 5419푸는데(다른데서도) 유용한 자료구조
*             [[Segment Tree]]
* */
public class SegmentTree {
    static int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
    static int[] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int treeHeight = (int)(Math.ceil(log(2,N)));
        int treeSize = 1<<(treeHeight+1);
        tree = new int[treeSize]; // note. 1 << N 하면 2의 거듭제곱을 간편하게!

        makeSegmentTree(0,0, N-1);

        Arrays.stream(arr).forEach(it -> System.out.print(it+", "));
        System.out.println("");
        Arrays.stream(tree).forEach(it -> System.out.print(it+", "));
    }

    static double log(int base, int x) {
        return Math.log10(x)/Math.log10(base);
    }

    static int makeSegmentTree(int node, int start, int end) {
        if (start >= end) // leaf node일때.
            return tree[node] = arr[start];

        int mid = (start+end)>>1;

        return tree[node] = makeSegmentTree(node*2+1, start, mid) + makeSegmentTree(node*2+2, mid+1, end);
    }

    static int prefixSum(int current, int start, int end, int left, int right) { // [left,right] -> tree가 가지는 range, [start,end] -> 찾고자 하는 구간
        if (start > right || end < left)
            return 0;
        else if ( left <= start && end <= right)
            return tree[current];
        else {
            int mid = (start+end)>>1;
            return prefixSum(current*2+1, start, mid, left, right) + prefixSum(current*2+2, mid+1, end, left, right);
        }
    }

    static void update(int changedIndex, int diff, int current, int start, int end) {
        if (changedIndex < start || changedIndex > end)
            return;

        tree[current] += diff;

        if (start != end) {
            int mid = (start+end)/2;
            update(changedIndex, diff, current*2+1, start, mid);
            update(changedIndex, diff, current*2+2, mid+1, end);
        }
    }
}
