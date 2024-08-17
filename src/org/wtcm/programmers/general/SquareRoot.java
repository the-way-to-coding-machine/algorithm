package org.wtcm.programmers.general;

//임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
//n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
//https://school.programmers.co.kr/learn/courses/30/lessons/12934

class SquareRoot {
    public long solution(long n) {
        long answer = -1;
        double x = Math.sqrt(n);            // 제곱근은 항상 double로 반환

        if(x - (int)(x) > 0) {              // 따라서 n이 정수가 아닐 경우 제곱근은 소수점을 가지므로 이를 확인
            return answer;
        }

        answer = (long)(Math.pow(x+1, 2));      // n이 정수가 맞으면 정답 도출하는 과정 거침 (x+1의 제곱, pow 역시 double로 반환됨)
        return answer;
    }
}