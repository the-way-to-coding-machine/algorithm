package org.wtcm.ln2021;

import java.util.Arrays;

public class Q3 {
    static int min = Integer.MAX_VALUE;
    static int sum;

    public static void main(String[] args) {
//        int n = 734298552;
        int n = 10007;
//        int n = 9;
        Arrays.stream(solution(n)).forEach(System.out::println);
    }

    static int[] solution(int n) {
        String number = String.valueOf(n);

        split(number, 0);

        return new int[]{min, sum};
    }

    static void split(String number, int cnt) { //이걸 재귀함수로...
        if (number.length() == 1) {
            sum = Integer.parseInt(number);
            min = Math.min(cnt, min);
            return;
        }

        // note. caching을 하면 훨씬 빨리할 수 있지만 이 문제에서는 input이 작아서 brute force도 충분히 가능..

        for (int position = 1; position < number.length(); position++) {
            int left = Integer.parseInt(number.substring(0, position));
            int right = Integer.parseInt(number.substring(position));

            if (number.charAt(position) == '0')
                if (position == number.length() - 1) right = 0;
                else continue;

            split(String.valueOf(left + right), cnt + 1);
        }
    }
}
