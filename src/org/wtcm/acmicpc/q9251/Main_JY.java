package org.wtcm.acmicpc.q9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_JY {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for (int idx1 = 1; idx1 <= str1.length(); idx1++)
            for (int idx2 = 1; idx2 <= str2.length(); idx2++)
                if (str1.charAt(idx1-1) == str2.charAt(idx2-1))
                    dp[idx1][idx2] = dp[idx1-1][idx2-1] + 1;
                else
                    dp[idx1][idx2] = Math.max(dp[idx1][idx2-1], dp[idx1-1][idx2]);

        System.out.println(dp[str1.length()][str2.length()]);
    }
}
