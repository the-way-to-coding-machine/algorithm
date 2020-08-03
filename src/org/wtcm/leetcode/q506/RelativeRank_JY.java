package org.wtcm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class RelativeRank_JY {
    public String[] solution(int[] scores) {
        // input = [5, 4, 3, 2, 1] ==> [g, s, b, 4, 5],
        // input = [1, 4, 2, 5, 3] ==> [5, s, 4, g, b]
        // ranks = [5, 4, 3, 2, 1]
        String gold = "Gold Medal";
        String silver = "Silver Medal";
        String bronze = "Bronze Medal";
        List<String> answer = new ArrayList<String>();

        LinkedHashMap<Integer, String> scoreMap = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> rankMap = new LinkedHashMap<>();
        int[] ranks = scores;

        for (int score : scores) {
            scoreMap.put(score, String.valueOf(score));
        } // 얘는 순서대로
        Arrays.sort(ranks);
        int r = ranks.length;
        for (int i : ranks) {
            if (r == 3) {
                rankMap.put(i, bronze);
            } else if (r == 2) {
                rankMap.put(i, silver);
            } else if (r == 1) {
                rankMap.put(i, gold);
            } else {
                rankMap.put(i, String.valueOf(r));
            }
            r--;
        } // 얘는 순위대로

        for (Integer score : new ArrayList<>(scoreMap.keySet())) {
            String rank = rankMap.get(score);
            answer.add(rank);
        }

        return answer.toArray(new String[0]);
    }
}
//      /* leet code best time answer*/

//    public String[] findRelativeRanks(int[] nums) {
//        String[] rank = new String[nums.length];
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        for(int x : nums){
//            max = Math.max(x, max);
//            min = Math.min(x, min);
//        }
//        int[] index = new int[max - min + 1];
//        for(int i = 0; i < nums.length; i++)
//            index[nums[i] - min] = i+1;
//        int r = 1;
//        for(int i = index.length - 1; i >= 0; i--){
//            if(index[i] == 0) continue;
//            if(r == 1) rank[index[i] - 1] = "Gold Medal";
//            else if(r == 2) rank[index[i] - 1] = "Silver Medal";
//            else if(r == 3) rank[index[i] - 1] = "Bronze Medal";
//            else rank[index[i] - 1] = Integer.toString(r);
//            r++;
//        }
//
//        return rank;
//    }
//
//      /* leet code best space answer */
//    public String[] findRelativeRanks(int[] nums) {
//        TreeMap<Integer, Integer> scoreToIndex = new TreeMap<>();
//        for (int i = 0; i < nums.length; ++i) {
//            scoreToIndex.put(nums[i], i);
//        }
//        String[] ans = new String[nums.length];
//        int rank = nums.length;
//        for (Integer i : scoreToIndex.values()) {
//            if (rank > 3) {
//                ans[i.intValue()] = String.valueOf(rank);
//            } else if (rank == 3) {
//                ans[i.intValue()] = "Bronze Medal";
//            } else if (rank == 2) {
//                ans[i.intValue()] = "Silver Medal";
//            } else {
//                ans[i.intValue()] = "Gold Medal";
//            }
//            rank--;
//        }
//        return ans;
//    }
