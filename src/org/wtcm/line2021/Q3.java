package org.wtcm.line2021;

import java.util.Arrays;

public class Q3 {
    public static void main(String[] args) {
        int n = 73425;
//        int n = 10007;
//        int n = 9;
        Arrays.stream(solution(n)).forEach(System.out::println);
    }

    static int[] solution(int n) {
        String number = String.valueOf(n);

        for (int pos = 1; pos < number.length(); pos++){
            Integer.parseInt(number.substring(0,pos));
            Integer.parseInt(number.substring(pos));
        }
        return null;
    }

    static int split() { //이걸 재귀함수로...
        return 0;
    }
}
