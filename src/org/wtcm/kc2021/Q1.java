package org.wtcm.kc2021;

import java.util.HashSet;

public class Q1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] g = {4, 5, 3, 2, 1};
        int[] w = {2, 4, 4, 5, 1};

        int[] g2 = {5, 4, 5, 4, 5};
        int[] w2 = {1, 2, 3, 5, 4};

        System.out.println(s.solution(g2,w2));
    }

    private static class Solution {
        public int solution(int[] gift_cards, int[] wants) {
            int answer = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int card : gift_cards)
                set.add(card);

            for (int want : wants)
                if (!set.contains(want))
                    answer++;
                else set.remove(want);

            return answer;
        }
    }
}