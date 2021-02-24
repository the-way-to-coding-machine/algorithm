package org.wtcm.acmicpc.q11XXX.q11066;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[] sum;
    static int[] files;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int ans;
        StringTokenizer st;

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            dp = new int[n+1][n+1];
            sum = new int[n+1];
            files = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1] + files[i]; // 부분합을 쓴다.
            }

            ans = merge();
            bw.write(ans+"\n");
            bw.flush();
        }
        bw.close();
    }

    private static int merge() {
        /*
                dp[i][j] --> i ~ j번째 합의 최솟값
                dp[i][j] == dp[i][k] + dp[k+1][j]
                dp[i][i] = files[i]
                dp[i][i+1] = files[i] + files[i+1]
                dp[i][i+2] =
        * */
        for (int len = 1; len < n; len++) {
            for (int i = 1; i+len <= n; i++) {
                int j = i+len;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int sumIJ = sum[j] - sum[i-1];
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sumIJ);
                }
            }
        }
        return dp[1][n];
    }
}
