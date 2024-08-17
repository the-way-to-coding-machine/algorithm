package org.wtcm.programmers.general;

//자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
//예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
//https://school.programmers.co.kr/learn/courses/30/lessons/12931


public class SumDigit {
    public int solution(int n) {
        int answer = 0;     // answer 초기화
        String[] sArr = String.valueOf(n).split("");    // 순회 위해 각 자릿수 찢어서 배열에 담음

        for(String s : sArr) {
            answer += Integer.valueOf(s);       // 각 자릿수 순회하면서 Integer로 형 변환 후 answer에 더해가기
        }

        System.out.println("Hello Java");

        return answer;
    }

    public static void main(String[] args) {
        SumDigit sd = new SumDigit();
        sd.solution(29483);
    }
}