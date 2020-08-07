package org.wtcm.leetcode.q3;

import java.util.HashMap;

public class LongestSubstring_JY {
    public int lengthOfLongestSubstring(String s) {
        char[] string = s.toCharArray();
        HashMap<Character, Boolean> visited;
        if (s.length() <= 1) return s.length();

        int result = 1;

        for (int index = 0; index < string.length - 1; index++) {
            visited = new HashMap<>();
            for (int cur = index; cur < string.length; cur++) {
                if (!visited.containsKey(string[cur])) { // 새로운거
                    visited.put(string[cur], true);
                } else { // 중복
                    visited = new HashMap<>();
                    visited.put(string[cur], true);
                    break;
                }
                result = Math.max(result, visited.size());
            }
        }
        return result;
    }
}

/*
 char[] chars = s.toCharArray();
 if (chars.length <= 1) return chars.length;
 int result = 1;

 int start = 0;
 // loop at each step forward
 for (int end = 1; end < chars.length; end++) {
 for (int i = start; i < end; i++) {
 if (chars[i] == chars[end]) {
 start = i + 1;
 break;
 }
 }
 result = Math.max(result, end - start + 1);
 }
 return result;
 */