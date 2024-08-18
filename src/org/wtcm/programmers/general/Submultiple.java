package org.wtcm.programmers.general;

// 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
// https://school.programmers.co.kr/learn/courses/30/lessons/12928

class Submultiple {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++) {           // n/2 ~ n 사이에는 약수가 없으므로 n의 절반까지만 반복문이 돌고 구하고 return할때
            if(n % i == 0) {                    // n을 마저 더해주는 식으로 코드를 짰다면 훨씬 효율적이었을 것.
                answer += i;
            }
        }
        return answer;
    }
}
