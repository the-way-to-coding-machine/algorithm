package org.wtcm.cp2021;

import java.util.HashMap;

public class Q3 {
    public static void main(String[] args) {
        int[] score = {24, 22, 20, 10, 5, 3, 2, 1};
        int k = 3;
//        int[] score = {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100};
//        int k = 2;

        Task question = new Task();
        System.out.println(question.solution(k, score));
    }

        private static class Task {
        HashMap<Integer, Integer> map = new HashMap<>();
        int solution(int k, int[] score) {
            boolean[] total = new boolean[score.length];
            int[] arr = new int[score.length];

            for (int i = 1; i < score.length; i++) {
                int sub = Math.abs(score[i] - score[i-1]);
                arr[i] = sub;
                if (map.containsKey(sub)) {
                    map.put(sub, map.get(sub)+1);
                } else {
                    map.put(sub, 1);
                }
            }

            int ans = 0;
            for (boolean b : total) if (!b) ans++;
            return ans;
        }
    }


}
