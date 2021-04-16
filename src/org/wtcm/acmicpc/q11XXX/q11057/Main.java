package org.wtcm.acmicpc.q11XXX.q11057;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int modulo = 10007;

        long[][] dp = new long[N + 1][10];

        dp[0][0] = 1;
        for (int n = 1; n <= N; n++) {
            dp[n][0] = 1;
            for (int tail = 1; tail < 10; tail++) {
                dp[n][tail] = (dp[n][tail - 1] + dp[n - 1][tail]) % modulo;
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[N][i];
            ans %= modulo;
        }

        bw.write(ans + "\n");
        bw.close();
    }
}
