package org.wtcm.devmatching2021;

public class Q2 {
    public static void main(String[] args) {
        Solution s = new Solution();

        int r = 6;
        int r2 = 3;
        int r3 = 100;

        int c = 6;
        int c2 = 3;
        int c3 = 97;

        int[][] q = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[][] q2 = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};
        int[][] q3 = {{1, 1, 100, 97}};

        int[] ans = s.solution(r, c, q);

        for (int a : ans)
            System.out.print(a + " ");
    }

    private static class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = {};



            return answer;
        }
    }
}
