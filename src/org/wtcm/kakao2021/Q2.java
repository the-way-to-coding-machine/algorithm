package org.wtcm.kakao2021;

import java.util.*;
import java.util.stream.Collectors;

public class Q2 {
    static String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
    static int[] course = {2, 3, 4};
    static LinkedHashMap<Character, Integer> menu = new LinkedHashMap<>();
    static List<Map.Entry> entries;
    static StringBuilder set;
    static HashMap<String, Integer> picked;
    static List<String> menus = new ArrayList<>();
    static int max;

    public static void main(String[] args) {
        String[] answer;

        for (int i = 0; i < orders.length; i++) {
            String order = orders[i];
            for (int j = 0; j < orders[i].length(); j++) {
                if (menu.containsKey(order.charAt(j))) {
                    menu.put(order.charAt(j), (menu.get(order.charAt(j)) + 1));
                } else {
                    menu.put(order.charAt(j), 0);
                }
            }
        }
        entries = new ArrayList<>(menu.entrySet());

        entries = entries.stream()
                .filter(it -> (int) it.getValue() >= 2)
                .collect(Collectors.toList());

        entries.sort((e1, e2) -> (int) e2.getValue() - (int) e1.getValue());

        for (int number : course) { // 2개, 3개, 4개...
            max = 0;
            for (int i = 0; i < number; i++)
                max += (int)entries.get(i).getValue();

            picked = new HashMap<>();
            pick(0,0, entries.size(), number);
        }
        answer = new String[menus.size()];

        int idx = 0;
        for (String what : menus) {
            answer[idx++] = what;
        }
    }

    static void pick(int prefer, int cur, int total, int num) {
        if (num == 0) {
            if (prefer >= max) {
                set = new StringBuilder();
                for (String menu : picked.keySet()) {
                    set.append(menu);
                }
                menus.add(set.toString());
            }
            return;
        }

        String m;
        int p;
        for (int i = cur; i < total; i++) {
            m = entries.get(i).getKey().toString();
            p = (int)entries.get(i).getValue();
            picked.put(m, p);
            prefer += p;
            pick(prefer,i+1, total, num-1);
            picked.remove(entries.get(i).getKey().toString());
            prefer -= p;
        }
    }
}
