package org.wtcm.kakao2021;

import java.util.*;
import java.util.stream.Collectors;

public class Q2 {
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        Arrays.stream(solution(orders, course)).forEach(System.out::println);
    }

    static String[] solution(String[] orders, int[] course) {
        int idx = 0;
        for (int num : course) {
            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                pick(arr, 0, num);
            }
            for (Map.Entry e :map.entrySet().stream().filter(it -> it.getValue() == max).collect(Collectors.toList()))
                System.out.println(e.getKey());
            max = 0;
            map.clear();
        }
        return null;
    }
    static StringBuilder picked = new StringBuilder();
    static int max = 1;
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
