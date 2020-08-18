package org.wtcm.leetcode.q454;

public class Runner {
    public static void main(String[] args) {
        FourSum2_JY question = new FourSum2_JY();

        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};

//        int[] A = {0};
//        int[] B = {0};
//        int[] C = {0};
//        int[] D = {0};

        System.out.println(question.fourSumCount(A,B,C,D));
    }
}
