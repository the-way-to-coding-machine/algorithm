package org.wtcm.leetcode.q560;

public class Runner {
    public static void main(String[] args) {
//        int[] nums = {1,1,1};
//        int k = 2;

        int[] nums = {1,2,1,2,1};
        int k = 3;

//        int[] nums = {1,2,3};
//        int k = 3;

        SubarraySumEqualsK_JY question = new SubarraySumEqualsK_JY();
        System.out.println(question.solution(nums, k));
    }
}
