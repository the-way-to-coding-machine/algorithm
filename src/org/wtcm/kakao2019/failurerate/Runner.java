package org.wtcm.kakao2019.failurerate;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        FailureRate_JY question = new FailureRate_JY();

//        int N = 5;
//        int[] stages = {2,1,2,6,2,4,3,3};

        int N = 8;
        int[] stages = {1,2,3,4,5,6,7};

//        int N = 4;
//        int[] stages = {4,4,4,4,4};

        Arrays.stream(question.solution(N,stages)).forEach(System.out::println);
    }
}
