package org.wtcm.leetcode.q1;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        TwoSum_JY question = new TwoSum_JY();

        int[] nums = {2,7,11,15};
        int target = 9;

        Arrays.stream(question.twoSum(nums, target)).forEach(System.out::println);
    }
}
