package org.wtcm.leetcode.q830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositionsOfLargeGroup_JY {
    /**
     * find all character sequence that longer than 3.
     * then return those sequences' indices of start, end
     * <p>
     * todo 이런 stream 사용법을 익혀두면 코테푸는데 도움 많이 될듯..!!
     * List<Character> string = S.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
     */
    public List<List<Integer>> largeGroupPositions(String S) { // input : abbxxxxzzy
        char[] string = S.toCharArray();
        List<List<Integer>> result = new ArrayList<>();

        int cur = 0;
        for (int start = 0; start < string.length-1; ) {
            int end = start;

            int length = 0;
            for (cur = start+1; cur < string.length; cur++) {
                if (string[start] == string[cur]) {
                    ++length;
                } else break;
            }

            if (length >= 2) {
                result.add(new ArrayList<>(Arrays.asList(start, cur-1)));
            }
            start = cur;
        }
        return result;
    }
}

/*
 int index = 0, cur = index;
 for (; index < string.length; index += cur) {
 int start = index, end = start;
 for (cur = start; cur < string.length; cur++) {
 if (string[start] != string[cur]) {
 if (cur - start > 2) {
 end = cur-1;
 result.add(new ArrayList<>(Arrays.asList(start, end)));
 }
 cur -= start;
 break;
 }
 }
 }
 return result;
 */