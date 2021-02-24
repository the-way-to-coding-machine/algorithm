package org.wtcm.acmicpc.q11XXX.q11049;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int n;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][n+1];
        matrix = new int[n+1][2];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int ans = merge();
        bw.write(ans+"\n");
        bw.close();
    }

    static private int merge() {
        for (int i = 1; i < n; i++)
            dp[i][i + 1] = matrix[i][0] * matrix[i][1] * matrix[i+1][1];

        for (int len = 2; len <= n; len++) {
            for (int start = 1; start + len <= n; start++) {
                int end = start + len;
                for (int mid = start; mid < end; mid++) {
                    int res = dp[start][mid] + dp[mid+1][end] + multiply(matrix[start], matrix[mid], matrix[end]);
                    if (dp[start][end] == 0 || dp[start][end] > res) dp[start][end] = res;
                }
            }
        }
        return dp[1][n];
    }

    static private int multiply(int[] A, int[] B, int[] C) {
        return A[0]*B[1]*C[1];
    }
}
