package org.wtcm.programmers.general;

// 두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
// 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
// https://school.programmers.co.kr/learn/courses/30/lessons/77884

import java.util.stream.IntStream;

class CountDivisor {
    public int solution(int left, int right) {
        int answer = 0;
        int[] array = IntStream.rangeClosed(left, right).toArray();

        for(Integer n : array) {
            int cnt = 0;

            for(int i = 1; i <= right; i++) {
                if(n % i == 0) {
                    cnt++;
                }
            }

            if(cnt % 2 == 0) {
                answer += n;
            } else {
                answer -= n;
            }
        }

        return answer;
    }
}