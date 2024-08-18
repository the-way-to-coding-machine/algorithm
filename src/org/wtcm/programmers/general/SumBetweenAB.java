package org.wtcm.programmers.general;

//두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
//예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
//https://school.programmers.co.kr/learn/courses/30/lessons/12912


import java.util.stream.LongStream;

class SumBetweenAB {
    public long solution(int a, int b) {
        long answer = a;            // a, b가 같은 경우 값이 변하지 않으므로 둘 중 하나 아무거나 정답으로 return

        if(a != b && a > b) {       // a, b가 같지 않고 a가 더 클때
            answer = LongStream.rangeClosed(a,b).sum();     // a~b 사이 정수를 스트림에 담고 이를 더함.
        }
        if(a != b && a <b) {
            answer = LongStream.rangeClosed(b,a).sum();
        }

        return answer;
    }
}
