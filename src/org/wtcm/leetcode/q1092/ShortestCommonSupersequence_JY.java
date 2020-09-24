package org.wtcm.leetcode.q1092;

public class ShortestCommonSupersequence_JY {
    /* note.
            str1, str2 이렇게 두개의 문자열을 모두 포함하면서 가장 짧은 문자열을 구하라.
            (만약 답이 여러개일 경우에는 그 중 아무거나 가능)
            e.g)
                str1 = "abac",
                str2 = "cab"
                answer = "cabac" --> "c"+str1 (O), str2+"ac"(O)
              -
                answer:
                    1. LCS를 먼저 구한다 --> ab
                    2. str1,2에서 LCS가 아닌 글자들을 모은다 --> bccbaacca
    *
    * */
    public String shortestCommonSuperSequence(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 0; i <= length1; i++)
            for (int j = 0; j <= length2; j++)
                if (i == 0 || j == 0)
                    dp[i][j] = 0;

        for (int idx1 = 1; idx1 <= length1; idx1++) {
            for (int idx2 = 1; idx2 <= length2; idx2++) {
                if (str1.charAt(idx1 - 1) == str2.charAt(idx2 - 1))
                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                else
                    dp[idx1][idx2] = Math.max(dp[idx1][idx2 - 1], dp[idx1 - 1][idx2]);
            }
        }

        int idx1 = length1, idx2 = length2;
        StringBuffer result = new StringBuffer();
        while (idx1 > 0 && idx2 > 0) {
            if (str1.charAt(idx1 - 1) == str2.charAt(idx2 - 1)) {
                result.append(str1.charAt(idx1 - 1));
                idx1--; idx2--;
            } else {
                if (dp[idx1][idx2 - 1] > dp[idx1 - 1][idx2]) {
                    result.append(str2.charAt(idx2 - 1));
                    idx2--;
                } else {
                    result.append(str1.charAt(idx1 - 1));
                    idx1--;
                }
            }
        }
        while (idx1 > 0) {
            result.append(str1.charAt(idx1 - 1));
            idx1--;
        }
        while (idx2 > 0) {
            result.append(str2.charAt(idx2 - 1));
            idx2--;
        }

        result.reverse();
        return result.toString();
    }
}
