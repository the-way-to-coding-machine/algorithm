package org.wtcm.acmicpc.q16XXX.q16194;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] cards = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++)
            cards[i] = Integer.parseInt(input[i-1]);

        dp[1] = cards[1];
        for (int i = 2; i <= n; i++) {
            int min = cards[i];
            for (int j = 1; j < i; j++) {
                min = Math.min(min, dp[i-j] + dp[j]);
            }
            dp[i] = min;
        }
        bw.write(dp[n] + "\n");
        bw.close();
    }
}
