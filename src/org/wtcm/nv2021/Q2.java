package org.wtcm.nv2021;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 2}, {2, 1}, {2, 4}
                , {3, 5}, {5, 4}, {5, 7}
                , {7, 6}, {6, 8}};
        int n = 9;
        Task question = new Task();
        Arrays.stream(question.solution(edges, n)).forEach(System.out::println);
    }

    private static class Task {
        int[] solution(int[][] edges, int n) {
            return null;
        }
    }
}
