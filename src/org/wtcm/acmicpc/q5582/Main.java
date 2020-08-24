package org.wtcm.acmicpc.q5582;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
        String str1 = "ABRACADABRA";
        String str2 = "ECADADABRBCRDARA";
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        int max = 0;
        for (int idx1 = 1; idx1 <= str1.length() ; idx1++) {
            for (int idx2 = 1; idx2 <= str2.length() ; idx2++) {
                if (str1.charAt(idx1-1) == str2.charAt(idx2-1)) {
                    dp[idx1][idx2] = dp[idx1-1][idx2-1]+1;
                    max = Math.max(dp[idx1][idx2], max);
                }
            }
        }
        System.out.println(max);
    }
}
