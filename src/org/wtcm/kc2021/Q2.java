package org.wtcm.kc2021;

public class Q2 {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] needs = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
        int r = 2;

        System.out.println(s.solution(needs, r));
    }

    private static class Solution {
        static int[] bitset;

        public int solution(int[][] needs, int r) {
            bitset = new int[needs.length];
            for (int i = 0; i < needs.length; i++) {
                int set = makeBitset(needs[i]);
                bitset[i] = set;
            }

            int[] robotComb = nCr(needs[0].length, r);
            int answer = getMax(bitset, robotComb);

            return answer;
        }

        private static int[] nCr(int n, int r) {
            int[] arr = new int[n];
            int idx = 0;

            for (int i = 0; i < 1 << n; i++) {
                int cnt = 0;
                int set = 0;
                for (int j = 0; j < n; j++) {
                    if ((i & 1 << j) > 0) cnt++;
                }
                if (cnt == r) {
                    for (int j = 0; j < n; j++) {
                        if ((i & 1 << j) > 0) {
                            set += j;
                        }
                    }
                    arr[idx++] = set;
                }
            }
            return arr;
        }

        private static int getMax(int[] total, int[] sub) {
            int max = Integer.MIN_VALUE;

            for (int components : sub) {
                int cur = 0;
                for (int needs : total) {
                    if ((needs & components) == needs) cur++;
                }
                max = Math.max(max, cur);
            }

            return max;
        }

        private static int makeBitset(int[] arr) {
            int set = 0;
            for (int i = 0; i < arr.length; i++)
                if (arr[i] == 1) set += (1 << i);

            return set;
        }
    }
}
