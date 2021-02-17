package org.wtcm.acmicpc.q15XXX.q15989;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] dp;
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
        dp = new int[n+1];

        for (int input : list)
            bw.write(dp[input]+"\n");

        bw.close();
    }
}
