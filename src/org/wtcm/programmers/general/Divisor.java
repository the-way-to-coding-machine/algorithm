package org.wtcm.programmers.general;

// array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
// divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
// https://school.programmers.co.kr/learn/courses/30/lessons/12910

import java.util.Arrays;
import java.util.ArrayList;

class Divisor {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answerList = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                answerList.add(arr[i]);
            }
        }

        if(answerList.isEmpty()) {
            answerList.add(-1);
        }

        int[] answer = answerList.stream().mapToInt(s->s).toArray();
        Arrays.sort(answer);

        return answer;
    }
}

// Arrays.stream(array).filter(s -> s % divisor == 0).toArray();
// 이 한줄이면 리스트로 바꿨다가 다시 배열로 바꾸고 연산하는 과정이 모두 필요가 없어진다.