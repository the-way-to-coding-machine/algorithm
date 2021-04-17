package org.wtcm.acmicpc.q11XXX.q11722;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        int max = 0;

        for (int start = n-1; start >= 0; start--) {
            dp[start] = 1;
            for (int tail = start; tail < n; tail++) {
                if (seq[start] > seq[tail])
                    dp[start] = Math.max(dp[start], dp[tail] + 1);
            }
            max = Math.max(max, dp[start]);
        }

        bw.write(max+"\n");
        bw.close();
    }
}
