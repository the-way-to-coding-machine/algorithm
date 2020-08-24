package org.wtcm.acmicpc.q9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
        str1 = ACAYKP
        str2 = CAPCAK
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        String result = "";
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int length = 0;

        for (int idx1 = 1; idx1 <= str1.length(); idx1++)
            for (int idx2 = 1; idx2 <= str2.length(); idx2++)
                if (str1.charAt(idx1 - 1) == str2.charAt(idx2 - 1))
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1] + 1;
                else
                    dp[idx1][idx2] = Math.max(dp[idx1][idx2 - 1], dp[idx1 - 1][idx2]);

        System.out.println(dp[str1.length()][str2.length()]);

        int idx1=str1.length(), idx2=str2.length();
        while (dp[idx1][idx2] != 0) {
            if (dp[idx1][idx2] == dp[idx1 - 1][idx2])
                idx1--;
            else if (dp[idx1][idx2] == dp[idx1][idx2 - 1])
                idx2--;
            else {
                result = str1.charAt(idx1 - 1) + result;
                idx1--;
                idx2--;
            }
        }
        System.out.println(result);
    }
}
