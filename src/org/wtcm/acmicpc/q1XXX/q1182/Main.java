package org.wtcm.acmicpc.q1XXX.q1182;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static int n, s;
    static int[] seq;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(seq);

//        recursivePick(0, 0, 0);
        bitSet();

        bw.write(cnt + "\n");
        bw.close();
    }

    private static void recursivePick(int idx, int picked, int sum) {
        if (idx == n) {
            if (picked != 0 && sum == s) cnt++;
            return;
        }

        recursivePick(idx + 1, picked + 1, sum + seq[idx]);
        recursivePick(idx + 1, picked, sum);
    }

    private static void bitSet() {
        for (int subset = 1; subset < (1 << n); subset++) { // n개의 원소들이 하나씩 있/없는 경우의 수.
            int sum = 0;
            for (int element = 0; element < n; element++) {
                if ((subset & (1 << element)) != 0) // element번째 원소가 켜져있으면.. 그러니깐 subset의 원소들을 골라내는 작업.
                    sum += seq[element];
            }
            if (sum == s) cnt++;
        }
    }
}
