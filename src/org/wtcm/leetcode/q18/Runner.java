package org.wtcm.leetcode.q18;

public class Runner {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FourSum_JY question = new FourSum_JY();

        int[] nums = {1,0,-1,0,-2,2,1,3,4,5,8,9,11,16};
//        int[] nums = {0,0,0,0};
        int target = 0;

        question.fourSum(nums, target).forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println("elabsed : " + (end - start));
    }
}
