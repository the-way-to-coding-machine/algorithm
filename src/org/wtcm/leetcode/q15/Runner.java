package org.wtcm.leetcode.q15;

public class Runner {
    public static void main(String[] args) {
        ThreeSum_JY question = new ThreeSum_JY();

        int[] nums = {-1,0,1,2,-1,-4};

        question.threeSum(nums).forEach(System.out::println);
    }
}
