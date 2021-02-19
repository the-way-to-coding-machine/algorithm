package org.wtcm.acmicpc.q2XXX.q2579;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][2];
        int[] stair = new int[n+1];

        for (int i = 1; i <= n; i++) stair[i] = Integer.parseInt(br.readLine());

        dp[1][0] = stair[1];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stair[i];
            dp[i][1] = Math.max(dp[i-2][0], dp[i-1][0]) + stair[i];
        }

        bw.write(Math.max(dp[n][0], dp[n][1])+"\n");
        bw.close();
    }
}
