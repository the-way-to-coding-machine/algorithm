package org.wtcm.acmicpc.q9XXX.q9095;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int n =0;
        for (int i = 0; i < t; i++) {
            int input = Integer.parseInt(br.readLine());
            list.add(input);
            n = Math.max(n, input);
        }

        int[] dp = new int[n+1];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i = 4; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];

        for (int input : list)
            bw.write(dp[input]+"\n");

        bw.close();
    }
}
