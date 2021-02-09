package org.wtcm.acmicpc.q1XXX.q1949;

import java.io.*;
import java.util.Arrays;

public class Main_JY {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] population = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        map = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[input[0]][input[1]] = map[input[1]][input[0]] = 1;
        }

        dfs(1);

        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }

    static void dfs(int cur) {

    }
}

/*

7
1000 3000 4000 1000 2000 2000 7000
1 2
2 3
4 3
4 5
6 2
6 7

* */