package org.wtcm.kakao2021;

import java.util.*;
import java.util.stream.Collectors;

public class Q2 {
    static HashMap<String, Integer> map = new HashMap<>();
    static StringBuilder picked = new StringBuilder();
    static int max = 1;

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course = {2, 3, 5};
//
//        String[] orders = {"XYZ", "XWY", "WXA"};
//        int[] course = {2, 3, 4};

        String[] answer = solution(orders, course);
        Arrays.sort(answer/*, (s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s1.length()-s2.length()*/);

        Arrays.stream(answer).forEach(System.out::println);
    }

    static String[] solution(String[] orders, int[] course) {
        StringBuilder sb = new StringBuilder();
        for (int num : course) {
            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                pick(arr, 0, num);
            }
            // note. 풀긴 풀었는데 찝찝한 부분이 있다.. 좀 더 깔끔하게 풀 수 없을까..?
            for (Map.Entry e : map.entrySet().stream().filter(it -> it.getValue() == max && it.getValue() >= 2).collect(Collectors.toList()))
                sb.append(e.getKey()).append(",");
            max = 1;
            map.clear();
        }
        return sb.deleteCharAt(sb.length()-1).toString().split(",");
    }

    static void pick(char[] order, int cur, int toPick) {
        if (toPick == 0) {
            if (map.containsKey(picked.toString())) {
                if (max <= map.get(picked.toString()))
                    max++;
                map.put(picked.toString(), (map.get(picked.toString())+1));
            } else {
                map.put(picked.toString(), 1);
            }
            return;
        }

        for (int i = cur; i < order.length; i++) {
            picked.append(order[i]);
            pick(order, i+1, toPick-1);
            picked.deleteCharAt(picked.length()-1);
        }
    }
}
