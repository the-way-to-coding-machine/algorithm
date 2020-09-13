package org.wtcm.line2021;

import java.util.Arrays;

public class Q0 {
    static int[][] v = {{1, 4}, {3, 4}, {3, 10}};
//    static int[][] points = {{1, 1}, {2, 2}, {1, 2}};
public static void main(String[] args) {
    int[] answer = new int[2];

    if (v[0][0] == v[1][0]) { // 높이 나옴
        if (v[0][1] == v[2][1]) { // 구해야 하는 점은 1번째 점과 대각선
            answer[0] = v[2][0];
            answer[1] = v[1][1];
        } else {
            answer[0] = v[2][0];
            answer[1] = v[0][1];
        }
    } else if (v[0][1] == v[1][1]) { // 밑변 나옴
        if (v[0][0] == v[2][0]) { // 구해야 하는 점은 1번째 점과 대각선
            answer[0] = v[1][0];
            answer[1] = v[2][1];
        } else {
            answer[0] = v[0][0];
            answer[1] = v[2][1];
        }
    } else { // 대각선 나옴
        if (v[0][0] == v[2][0]) { //
            answer[0] = v[1][0];
            answer[1] = v[0][1];
        } else {
            answer[0] = v[0][0];
            answer[1] = v[1][1];
        }
    }
    Arrays.stream(answer).forEach(System.out::println);
}
}
