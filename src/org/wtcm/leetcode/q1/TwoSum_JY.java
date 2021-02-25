package org.wtcm.leetcode.q1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

    public int[] twoSumWithHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 있는지 없는지를 찾기 위해서는 굳이 Map이 아니라 HashSet을 써도 되겠다.
        // Map을 쓰면 Key, Value 두개의 값을 신경써야하니.. Set이 이런경우엔 더 나을듯.

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[] {i, map.get(target-nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public List<int[]> twoSumWithHashSet(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                result.add(new int[] {nums[i], target - nums[i]});
            } else {
                set.add(nums[i]);
            }
        }
        return result;
    }
}
