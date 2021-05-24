package org.wtcm.kintern2021;

import java.util.HashMap;

public class Q1 {
    public static void main(String[] args) {
        Solution s = new Solution();

        String a = "one4seveneight";
        String b = "23four5six7";
        String c = "9";
        System.out.println(s.solution(c));
    }

    private static class Solution {
        public int solution(String s) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("one", 1);
            map.put("two", 2);
            map.put("three", 3);
            map.put("four", 4);
            map.put("five", 5);
            map.put("six", 6);
            map.put("seven", 7);
            map.put("eight", 8);
            map.put("nine", 9);
            map.put("zero", 0);

            int start = 0;
            StringBuilder sb = new StringBuilder();
            for (int end = 0; end < s.length(); end++) {
                String num = s.substring(start, end+1);
                if (map.containsKey(num)) {
                    sb.append(map.get(num));
                    start = end+1;
                }

                char cur = s.charAt(end);
                if (0 <= cur - '0' && cur - '0' < 9) {
                    sb.append(cur);
                    start++;
                }
            }

            return Integer.parseInt(sb.toString());
        }
    }

}
