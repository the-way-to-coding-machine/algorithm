package org.wtcm.leetcode.q15;

import java.util.*;
import java.util.stream.IntStream;

public class ThreeSum_JY {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int first = 0; first < nums.length; first++) {
            if (first == 0 || nums[first] > nums[first-1]) {
                int start = first+1;
                int end = nums.length-1;

                while(start < end) {
                    int sum = nums[first]+nums[start]+nums[end];

                    if (sum == 0) {
                        result.add(Arrays.asList(nums[first],nums[start], nums[end]));
                        start++;    end--;
                        while(start < end && nums[start] == nums[start-1]) start++;
                        while(start < end && nums[end] == nums[end+1]) end--;
                    } else if(sum < 0)  start++;
                    else    end--;
                }
            }
        }
        return result;
    }
}
