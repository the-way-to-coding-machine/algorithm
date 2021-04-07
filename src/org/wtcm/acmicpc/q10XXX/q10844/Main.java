package org.wtcm.acmicpc.q10XXX.q10844;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int modulo = 1000000000;

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        for (int i = 1; i < 10; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i-1][1] % modulo;
            for (int last = 1; last < 9; last++) {
                dp[i][last] = (dp[i-1][last-1] + dp[i-1][last+1]) % modulo;
            }
            dp[i][9] = dp[i-1][8] % modulo;
        }

        long ans = 0;
        for (int i = 0; i < 10; i++)
            ans += dp[n][i];

        bw.write(ans%modulo + "\n");
        bw.close();
    }
}
