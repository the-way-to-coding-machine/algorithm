package org.wtcm.acmicpc.q5582;

public class Runner {
    public static void main(String[] args) {
        LongestCommonSubstring question = new LongestCommonSubstring();

        String str1 = "ABRACADABRA";
        String str2 = "ECADADABRBCRDARA";

        System.out.println(question.solution(str1, str2));
    }
}
