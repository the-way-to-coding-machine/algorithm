package org.wtcm.acmicpc.q12865;

public class Runner {
    public static void main(String[] args) {
        NormalKnapsak question = new NormalKnapsak();

        int items = 4;
        int limit = 7;
        int[] weight = {6, 4, 3, 5}, values = {13, 8, 6, 12};

        System.out.println(question.solution(items, limit, weight, values));
    }
}
