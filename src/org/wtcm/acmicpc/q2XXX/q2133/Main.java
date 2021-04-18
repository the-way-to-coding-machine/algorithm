package org.wtcm.acmicpc.q2XXX.q2133;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        if (n % 2 == 0) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[2] = 3;
            if (n > 2) {
                dp[4] = 11;
                for (int len = 6; len <= n; len += 2) {
                    dp[len] = dp[len - 2] * 3;
                    for (int ex = 4; ex <= len; ex += 2) {
                        dp[len] += (dp[len - ex] * 2);
                    }
                }
            }
            ans = dp[n];
        }

        bw.write(ans + "\n");
        bw.close();
    }
}
