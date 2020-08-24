package org.wtcm.acmicpc.q9251;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] dp;
        String str1, str2;

        str1 = sc.nextLine();
        str2 = sc.nextLine();

        dp = new int[str1.length()+1][str2.length()+1];

        for (int idx2 = 1; idx2 <= str2.length(); idx2++) {
            for (int idx1 = 1; idx1 <= str1.length(); idx1++) {
                if (str1.charAt(idx1-1) == str2.charAt(idx2-1)) {
                    dp[idx2][idx1] = dp[idx2][idx1-1] + 1;
                } else {
                    dp[idx2][idx1] = Math.max(dp[idx2][idx1-1], dp[idx2-1][idx1]);
                }
            }
        }
        System.out.println(dp[str1.length()][str2.length()]);
    }
}