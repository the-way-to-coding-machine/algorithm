package org.wtcm.ln2021;


import java.util.LinkedHashMap;

public class Q1 {

    public static void main(String[] args) {
//        int[][] boxes = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
//        int[][] boxes = {{1,2},{3,4},{5,6}};
        int[][] boxes = {{1,2},{2,3},{3,1}};

        System.out.println(solution(boxes));
    }

    static int solution(int[][] boxes) {
        LinkedHashMap <Integer, Integer> map = new LinkedHashMap<>();

        for (int boxNum = 0; boxNum < boxes.length; boxNum++) {
            for (int itemNum = 0; itemNum < 2; itemNum++) {
                if (map.containsKey(boxes[boxNum][itemNum]))
                    map.put(boxes[boxNum][itemNum], map.get(boxes[boxNum][itemNum])+1);
                else
                    map.put(boxes[boxNum][itemNum], 1);
            }
        }
        int answer = 0;
        for (int num : map.values()) {
            if ( num >= 2) answer += num/2;
            else answer += num;
        }
        return answer-boxes.length;
    }
}
