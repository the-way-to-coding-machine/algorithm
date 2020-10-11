package org.wtcm.coupang2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q4 {
    public static void main(String[] args) {
        Task question = new Task();
        System.out.println(question.solution());
    }

    private static class Task {
        String[][] roads = {
                {"ULSAN","BUSAN"},{"DAEJEON","ULSAN"}
                ,{"DAEJEON","GWANGJU"},{"SEOUL","DAEJEON"}
                ,{"SEOUL","ULSAN"},{"DAEJEON","DAEGU"}
                ,{"GWANGJU","BUSAN"},{"DAEGU","GWANGJU"}
                ,{"DAEGU","BUSAN"},{"ULSAN","DAEGU"}
                ,{"GWANGJU","YEOSU"},{"BUSAN","YEOSU"}};

        String departure = "SEOUL";
        String hub = "DAEGU";
        String arrival = "YEOSU";
        HashMap<String, Integer> cache1 = new HashMap<>();
        HashMap<String, Integer> cache2 = new HashMap<>();

        HashMap<String, List<String>> map = new HashMap<>();
        int solution() {
            for (int i = 0; i < roads.length; i++) {
                String from = roads[i][0];
                String to = roads[i][1];

                if (map.containsKey(from)) {
                    List<String> cities = map.get(from);
                    cities.add(to);
                    map.put(from, cities);
                } else {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(to);
                    map.put(from, tmp);
                }
            }
            int f = traverse1(departure);
            if (f == 0) return 0;
            int s = traverse2(hub);
            if (s == 0) return 0;

            return (f*s) % 10007;
        }

        int traverse1(String cur) {
            if (cur.equals(hub)) {
                return 1;
            }

            if (cache1.get(cur) != null) return cache1.get(cur);

            int cnt = 0;
            if(map.get(cur) != null) {
                for (String next : map.get(cur)) {
                    cnt += traverse1(next);
                }
            }
            cache1.put(cur, cnt);

            return cache1.get(cur);
        }

        int traverse2(String cur) {
            if (cur.equals(arrival)) {
                return 1;
            }
            if (cache2.get(cur) != null) return cache2.get(cur);

            int cnt = 0;
            if (map.get(cur) != null) {
                for (String next : map.get(cur)) {
                    cnt += traverse2(next);
                }
            }
            cache2.put(cur, cnt);

            return cache2.get(cur);
        }
    }
}
