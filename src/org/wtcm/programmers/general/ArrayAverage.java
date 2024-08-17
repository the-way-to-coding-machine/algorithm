package org.wtcm.programmers.general;

//2024-08-17
//정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
//https://school.programmers.co.kr/learn/courses/30/lessons/12944


import java.util.Arrays;

class ArrayAverage {
    public double solution(int[] arr) {
        double answer = Arrays.stream(arr).sum() / (double) arr.length;         // 나누셈 결과를 소수점까지 살리고 싶으면 나누는 수를 double로 처리해주면된다.
                                                                            // stream 메소드에는 평균 구하는 메소드가 있다. 그러므로
        return answer;                                                      // .average.getsAsDouble로 했으면 더 좋았겠다.
    }
}

class Main393 {
    public static void main(String[] args) {
        ArrayAverage aa = new ArrayAverage();
        int[] arr = {1,2,3,4};
        System.out.println(aa.solution(arr));
    }
}