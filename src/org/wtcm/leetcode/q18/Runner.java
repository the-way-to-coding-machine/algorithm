package org.wtcm.leetcode.q18;

public class Runner {
    public static void main(String[] args) {
        FourSum_JY question = new FourSum_JY();

        int[] nums = {1,0,-1,0,-2,2};
//        int[] nums = {0,0,0,0};
        int target = 0;

        question.fourSum(nums, target).forEach(System.out::println);
    }
}
