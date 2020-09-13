package org.wtcm.line2021;

import java.util.Arrays;

public class Q4 {
    static int[] xMove = {0, 1, -1, 0}; // 밑  왼 위
    static int[] yMove = {1, 0, 0, -1};
    static boolean[][] visited;
    static int length;
    static int N, M;
    static int[][] map;
    static int[] wallX = {1, 0, 0, -1}; // 오 위 밑 위
    static int[] wallY = {0, -1, 1, 0};

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 1}
                , {0, 1, 0, 0}
                , {0, 0, 0, 0}
                , {1, 0, 1, 0}};
//        int[][] maze = {
//                  {0, 1, 0, 0, 0, 0}
//                , {0, 1, 0, 1, 1, 0}
//                , {0, 1, 0, 0, 1, 0}
//                , {0, 1, 1, 1, 1, 0}
//                , {0, 1, 0, 0, 0, 0}
//                , {0, 0, 0, 1, 1, 0}};

        System.out.println(solution(maze));
    }

    static int solution(int[][] maze) {
        M = maze.length;
        N = maze[0].length;
        visited = new boolean[M][N];
        map = maze;

        for (int i = 0; i < M; i++)
            Arrays.fill(visited[i], false);

        length = 0;
        dfs(0, 0);
        return length;
    }

    static void dfs(int y, int x) {
        if (x == N - 1 && y == M - 1) {
            return;
        }
        length++;
        for (int direction = 0; direction < 4; direction++) {
            int wallPosX = x + wallX[direction];
            int wallPosY = y + wallY[direction];

            if (wallPosY >= N || wallPosY < 0 || wallPosX >= M || wallPosX < 0) continue;
            if (map[wallPosY][wallPosX] != 1) continue;

            int nextX = x + xMove[direction];
            int nextY = y + yMove[direction];

            if (nextX >= N || nextX < 0 || nextY >= M || nextY < 0) continue; // 구석
            if (map[nextY][nextX] != 0) continue; // 벽

            dfs(nextY, nextX);
        }
    }
}
