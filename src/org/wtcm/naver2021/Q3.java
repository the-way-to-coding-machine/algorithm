package org.wtcm.naver2021;

import java.util.HashSet;

public class Q3 {
    public static void main(String[] args) {
        Sol s = new Sol();
        int[] a = {3,2,-2,5,-3};
        int[] b = {1,1,2,-1,2,-1};
        int[] c = {1,2,3,-4};
        System.out.println(s.solution(b));
    }

    private static class Sol {
        public static int solution(int[] A) {
            HashSet<Integer> set = new HashSet<>();
            int max = 0;

            for (int i = 0; i < A.length; i++) {
                if (set.contains(-A[i])) {
                    max = Math.max(max, Math.abs(A[i]));
                } else {
                    set.add(A[i]);
                }
            }
            return max;
        }
    }
}
