package org.wtcm.programmers.general;

import java.util.Arrays;
import java.util.stream.IntStream;

class ReverseArray {
    public int[] solution(long n) {
        StringBuilder stringN = new StringBuilder(String.valueOf(n));

        String[] answerArr = stringN.reverse().toString().split("");

        int[] answer = Arrays.stream(answerArr).mapToInt(s->Integer.parseInt(s)).toArray();

        return answer;
    }
}
