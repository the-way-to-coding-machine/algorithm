package org.wtcm.acmicpc.q1XXX.q1520;

import java.io.*;
import java.util.Arrays;

public class Main_JY {
    static int N,M;
    static int[][] map;
    static int[][] dp;
    static int[] xPos = {1,0,-1,0};
    static int[] yPos = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);   M = Integer.parseInt(firstLine[1]);
        map = new int[N][M];
        dp = new int[N][M]; // dp[N][M] --> (N, M)을 지나서 도착하는 경우의 수. -1이 아니라면 이미 구해진거니까 그대로 쓰기만 하면됨.
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);

        for (int row = 0; row < N; row++)
            map[row] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        System.out.println(dfs(0,0));
    }

    public static int dfs(int row, int col) {
        if (row == N-1 && col == M - 1)
            return 1;

        if (dp[row][col] == -1) {
            dp[row][col] = 0;
            for (int direction = 0; direction < 4; direction++) {
                int nextCol = col + xPos[direction];
                int nextRow = row + yPos[direction];

                if (!isIn(nextRow, nextCol)) continue;
                if (map[row][col] <= map[nextRow][nextCol]) continue;

                dp[row][col] += dfs(nextRow, nextCol);
            }
        }

        return dp[row][col];
    }

    public static boolean isIn(int row, int col) {
        return (0 <= row && row < N) && (0 <= col && col < M);
    }
}
