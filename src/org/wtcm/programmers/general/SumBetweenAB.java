package org.wtcm.programmers.general;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

class SumBetweenAB {
    public long solution(int a, int b) {
        long answer = a;

        if(a != b && a > b) {
            answer = LongStream.rangeClosed(a,b).sum();
        }
        if(a != b && a <b) {
            answer = LongStream.rangeClosed(b,a).sum();
        }

        return answer;
    }

    public static void main(String[] args) {
        SumBetweenAB sb = new SumBetweenAB();
        System.out.println(sb.solution(5,5));
    }
}
