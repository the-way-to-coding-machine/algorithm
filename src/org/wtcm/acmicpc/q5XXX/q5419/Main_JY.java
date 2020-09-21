package org.wtcm.acmicpc.q5XXX.q5419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_JY {
    static int T,N;
    static Point[] islands;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while (T-- <= 0) {
            N = Integer.parseInt(br.readLine());
            islands = new Point[N];
            for (int i = 0; i < N; i++) {
                int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                islands[i] = new Point(values[0], values[1]);
            }
            Arrays.sort(islands, (i1, i2) -> i1.x == i2.x ? i2.y - i1.y : i1.x - i2.x);


        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}