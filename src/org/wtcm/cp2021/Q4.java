package org.wtcm.cp2021;

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
        HashMap<String, Integer> cache = new HashMap<>();
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

            int f = traverse(departure, hub);
            if (f == 0) return 0;
            cache = new HashMap<>();
            int s = traverse(hub, arrival);
            if (s == 0) return 0;

            return (f*s) % 10007;
        }

        int traverse(String cur, String dest) {
            if (cur.equals(dest)) {
                return 1;
            }

            if (cache.get(cur) != null) return cache.get(cur);

            int cnt = 0;
            if(map.get(cur) != null) {
                for (String next : map.get(cur)) {
                    cnt += traverse(next, dest);
                }
            }
            cache.put(cur, cnt);

            return cache.get(cur);
        }
    }
}
