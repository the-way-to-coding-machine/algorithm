package org.wtcm.acmicpc.q1XXX.q1149;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[][] map;
    static int[][] memo;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][3];
        memo = new int[n][3];
        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++)
            min = Math.min(min, paint(0, i));

        bw.write(min+"\n");
        bw.close();
    }

    private static int paint(int house, int color) {
        if (house == n)
            return 0;

        if (memo[house][color] != 0)
            return memo[house][color];

        int min = Integer.MAX_VALUE;
        for (int c = 0; c < 3; c++) {
            if (color == c) continue;
            min = Math.min(min, paint(house+1, c));
        }
        return memo[house][color] = (map[house][color] + min);
    }
}
