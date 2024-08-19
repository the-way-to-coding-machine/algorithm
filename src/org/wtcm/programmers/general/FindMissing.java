package org.wtcm.programmers.general;


// 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
// numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
// https://school.programmers.co.kr/learn/courses/30/lessons/86051


import java.util.stream.IntStream;

class FindMissing {
    public int solution(int[] numbers) {
        int answer = 0;
        int sum = IntStream.rangeClosed(0,9).sum();

        for(int i = 0; i <= 9; i++) {           // 필요없는 반복문...
            for(Integer n : numbers) {
                if(i == n) {
                    sum = sum - i;
                }
            }
        }

        return sum;
    }
}