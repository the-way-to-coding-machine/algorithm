package org.wtcm.programmers.general;

//자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
//https://school.programmers.co.kr/learn/courses/30/lessons/12932


import java.util.Arrays;

class ReverseArray {
    public int[] solution(long n) {
        StringBuilder stringN = new StringBuilder(String.valueOf(n));           //reverse 메소드 사용위해 String으로 변환해 StringBuilder에 담음

        String[] answerArr = stringN.reverse().toString().split("");      //StringBuilder는 객체이므로 toString 필요

        int[] answer = Arrays.stream(answerArr).mapToInt(s->Integer.parseInt(s)).toArray();
        // answerArr는 배열이므로 Arrays.stream 사용, 원소들을 모두 Integer로 변환해 스트림에 담음, 배열로 다시 담음. 이때 오토 언박싱 진행됨

        return answer;
    }
}
