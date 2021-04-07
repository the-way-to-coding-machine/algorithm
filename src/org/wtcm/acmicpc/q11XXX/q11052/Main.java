package org.wtcm.acmicpc.q11XXX.q11052;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n+1];
        dp[1] = cards[1];
        for (int i = 2; i <= n; i++) {
            int max = cards[i];
            for (int j = 1; j < i; j++) {
                max = Math.max(max, dp[i - j] + dp[j]);
            }
            dp[i] = max;
        }

        bw.write(dp[n] + "\n");
        bw.close();
    }
}
