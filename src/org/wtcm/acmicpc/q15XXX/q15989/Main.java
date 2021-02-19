package org.wtcm.acmicpc.q15XXX.q15989;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 0, t = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int input = Integer.parseInt(br.readLine());
            list.add(input);
            n = Math.max(n, input);
        }

        dp = new int[n+1][4];
        dp[1][1] = 1;
        dp[2][1] = 1; dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;
        for (int num = 4; num <= n; num++) {
            dp[num][1] = 1;
            dp[num][2] = dp[num-2][1] + dp[num-2][2];
            dp[num][3] = dp[num-3][1] + dp[num-3][2] + dp[num-3][3];
        }

        for (int input : list) {
            int ans = dp[input][1]+dp[input][2]+dp[input][3];
            bw.write(ans + "\n");
        }

        bw.close();
    }
}
