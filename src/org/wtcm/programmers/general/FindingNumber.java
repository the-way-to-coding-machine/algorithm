package org.wtcm.programmers.general;

//정수 num과 k가 매개변수로 주어질 때,
//num을 이루는 숫자 중에 k가 있으면 num의 그 숫자가 있는 자리 수를 return하고 없으면 -1을 return 하도록 solution 함수를 완성해보세요.
//https://school.programmers.co.kr/learn/courses/30/lessons/120904

import java.util.Arrays;

class FindingNumber {
    public int solution(int num, int k) {
        int answer = -1;            //반복문에서 k를 찾고 없으면 바로 -1 return하기 위해 초기값을 -1로 설정

        String[] numArray = String.valueOf(num).split("");      //num의 각 자릿수를 순회하면서 확인하기 위해 String으로 변환
        String kk = String.valueOf(k);                                //num과 변환 이유 동일

        for(String i : numArray) {
            if(i.equals(kk)) {
                answer = Arrays.asList(numArray).indexOf(i)+1;
            }
        }

        return answer;
    }
}