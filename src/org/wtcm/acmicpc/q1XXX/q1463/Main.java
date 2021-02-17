package org.wtcm.acmicpc.q1XXX.q1463;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }
        bw.write(dp[n]+"\n");
        bw.close();
    }
}
