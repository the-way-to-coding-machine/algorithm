package org.wtcm.line2021;


import java.util.Arrays;

public class Q4 {
    static int[] rowDir = {0, 1, 0, -1}; // 오 밑 왼 위
    static int[] colDir = {1, 0, -1, 0};
    static int width, height, length = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;

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
        height = maze.length;
        width = maze[0].length;
        map = maze;

        visited = new boolean[height][width];
        for (int i = 0; i < height; i++)
            Arrays.fill(visited[i], false);


//        simpleDFS(0, 0, 0);
        leftHandRule(0,0,0);

        return length;
    }

    static void leftHandRule(int row, int col, int move) {
        if (row == height - 1 && col == width - 1) {
            length = Math.min(length, move);
            return;
        }

        /*
         * 1. 좌벽 유무 확인
         *   --> 없으면 왼쪽으로
         *   --> 있으면 왼쪽으로 회전
         * 2.
         * */
        for (int turn = 0; turn < 4; turn++) {
            int nextRow = row + rowDir[turn];
            int nextCol = col + colDir[turn];

            int currentLeftRow = row + rowDir[(turn+3)%4];
            int currentLeftCol = col + colDir[(turn+3)%4];

            if (!isIn(currentLeftRow, currentLeftCol)) continue;

            if (!isIn(nextRow, nextCol)) continue;
            if (map[nextRow][nextCol] != 0) continue;

            leftHandRule(nextRow, nextCol, move+1);
        }
    }



//    static void simpleDFS(int row, int col, int cur) {
//        if (row == height - 1 && col == width - 1) {// 도착
//            length = Math.min(length,cur);
//            return;
//        }
//
//        if (!visited[row][col]) {
//            visited[row][col] = true;
//            for (int dir = 0; dir < 4; dir++) {
//                int nextRow = row + rowDir[dir];
//                int nextCol = col + colDir[dir];
//
//                if (!isIn(nextRow, nextCol)) continue;
//                if (map[nextRow][nextCol] != 0) continue;
//
//                simpleDFS(nextRow, nextCol, cur + 1);
//            }
//                visited[row][col] = false;
//        }
//    }

    static boolean isIn(int row, int col) {
        return row < height && row >= 0 && col < width && col >= 0;
    }
}
