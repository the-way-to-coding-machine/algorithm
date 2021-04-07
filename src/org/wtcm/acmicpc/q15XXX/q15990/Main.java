package org.wtcm.acmicpc.q15XXX.q15990;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int modulo = 1000000009;
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[100001][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        long ans = 0;
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (dp[n][1] == 0 && dp[n][2] == 0 && dp[n][3] == 0) {
                for (int i = 4; i <= n; i++) {
                    dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % modulo;
                    dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % modulo;
                    dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % modulo;
                }
            }
            ans = dp[n][1] + dp[n][2] + dp[n][3];
            bw.write(ans+"\n");
        }
        bw.close();
    }
}
