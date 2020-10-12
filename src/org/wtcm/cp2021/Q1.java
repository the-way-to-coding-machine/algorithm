package org.wtcm.cp2021;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        int N = 0;

        Task question = new Task();
        Arrays.stream(question.solution(N)).forEach(System.out::println);
    }

    private static class Task {
        int max = 0;
        int ans = 0;
        private int[] solution(int N) {
            for (int i = 2; i <= 9; i++) {
                int n = mult(N, i);
                if (n > max) {
                    ans = i;
                    max = n;
                }
            }
            return new int[] {ans, max};
        }

        int mult(int num, int k) {
            int mul = 1;
            while (num > 0) {
                int n = num % k;
                num = num / k;
                if (n > 0)
                    mul *= n;
            }
            return mul;
        }
    }
}
