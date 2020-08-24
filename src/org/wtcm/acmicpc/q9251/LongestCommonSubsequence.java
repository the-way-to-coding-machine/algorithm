package org.wtcm.acmicpc.q9251;

public class LongestCommonSubsequence {

    /*
        String str1 = "ACAYKP";
        String str2 = "CAPCAK";
    * */
    int[][] dp;
    int solution(String str1, String str2) {
        dp = new int[str1.length()+1][str2.length()+1];
        dp[0][0] = 0;

        for (int idx2 = 1; idx2 <= str2.length(); idx2++) {
            for (int idx1 = 1; idx1 <= str1.length(); idx1++) {
                if (str1.charAt(idx1-1) == str2.charAt(idx2-1)) {
                    dp[idx2][idx1] = dp[idx2][idx1-1] + 1;
                } else {
                    dp[idx2][idx1] = Math.max(dp[idx2][idx1-1], dp[idx2-1][idx1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
