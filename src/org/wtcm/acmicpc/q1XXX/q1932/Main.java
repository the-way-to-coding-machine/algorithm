package org.wtcm.acmicpc.q1XXX.q1932;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][n+1];
        dp[1][1] = map[1][1];
        for (int floor = 2; floor <= n; floor++) {
            dp[floor][1] = dp[floor-1][1] + map[floor][1];
            for (int idx = 2; idx < floor; idx++) {
                dp[floor][idx] = Math.max(dp[floor-1][idx-1], dp[floor-1][idx]) + map[floor][idx];
            }
            dp[floor][floor] = dp[floor-1][floor-1] + map[floor][floor];
        }
        Arrays.sort(dp[n]);
        bw.write(dp[n][n]+"\n");
        bw.close();
    }
}
