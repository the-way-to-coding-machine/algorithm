package org.wtcm.naver2021;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        Sol q = new Sol();
        int[] A = {1,2,5,9,9};
        System.out.println(q.solution(A, 9));
    }

    private static class Sol {
        int solution(int[] A, int X) {
            int N = A.length;
            if (N == 0) {
                return -1;
            }
            int l = 0;
            int r = N;
            while (l+1 < r) {
                int m = (l + r) / 2;
                if (A[m] > X) {
                    r = m-1;
                } else {
                    l = m;
                }
            }
            if (A[l] == X) {
                return l;
            }
            return -1;
        }
    }
}
//
//
//    int solution(int[] A, int X) {
//        int N = A.length;
//        if (N == 0) {
//            return -1;
//        }
//        int l = 0;
//        int r = N - 1;
//        while (l < r) {
//            int m = (l + r) / 2;
//            if (A[m] > X) {
//                r = m - 1;
//            } else {
//                l = m;
//            }
//        }
//        if (A[l] == X) {
//            return l;
//        }
//        return -1;
//    }
