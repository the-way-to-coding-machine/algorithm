package org.wtcm.leetcode.q1;

import java.util.HashMap;

public class TwoSum_JY {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            int cur = nums[i];
            for (int j = i+1; j < nums.length; j++)
                if (nums[j] == target-cur)
                    return new int[] {i,j};
        }

        return null;
    }

    public int[] twoSumWithHash(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[] {i, map.get(target-nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
