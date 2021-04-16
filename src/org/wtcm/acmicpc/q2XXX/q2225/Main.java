package org.wtcm.acmicpc.q2XXX.q2225;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int modulo = 1_000_000_000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N + 1][K + 1];

        for (int k = 1; k <= K; k++)
            dp[0][k] = 1;
        for (int n = 1; n <= N; n++)
            dp[n][1] = 1;

        for (int n = 1; n <= N; n++) {
            for (int k = 2; k <= K; k++) {
                dp[n][k] = dp[n-1][k] + dp[n][k-1];
                dp[n][k] %= modulo;
            }
        }
        bw.write(dp[N][K]+"\n");
        bw.close();
    }
}
