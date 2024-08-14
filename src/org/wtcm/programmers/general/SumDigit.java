package org.wtcm.programmers.general;

import java.util.Arrays;

public class SumDigit {
    public int solution(int n) {
        int answer = 0;
        String[] sArr = String.valueOf(n).split("");

        for(String s : sArr) {
            answer += Integer.valueOf(s);
        }

        System.out.println("Hello Java");

        return answer;
    }

    public static void main(String[] args) {
        SumDigit sd = new SumDigit();
        sd.solution(29483);
    }
}