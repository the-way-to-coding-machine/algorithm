package org.wtcm.devmatching2021;

import java.util.HashSet;

public class Q1 {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] l = {44, 1, 0, 0, 31, 25};
        int[] l2 = {0, 0, 0, 0, 0, 0};
        int[] l3 = {45, 4, 35, 20, 3, 9};

        int[] w = {31,10,45,1,6,19};
        int[] w2 = {38,19,20,40,15,25};
        int[] w3 = {20,9,3,45,4,35};

        int[] ans = s.solution(l2, w2);
        for (int a : ans)
            System.out.print(a+" ");

    }

    private static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int w : win_nums)
                set.add(w);

            int min = 0;
            int max = 0;
            for (int my : lottos) {
                if (my == 0) max++;
                if (set.contains(my)) min++;
            }
            max += min;
            return new int[] {7-max == 7 ? 6 : 7-max, 7-min == 7 ? 6 : 7-min};
        }
    }
}
