package org.wtcm.ln2021;


public class Q4 {
    static int[] rowDir = {0, 1, 0, -1}; // 오 밑 왼 위
    static int[] colDir = {1, 0, -1, 0};
    static int width, height, length;
    static int[][] map;

    public static void main(String[] args) {
//        int[][] maze = {
//                {0, 1, 0, 1}
//                , {0, 1, 0, 0}
//                , {0, 0, 0, 0}
//                , {1, 0, 1, 0}};
//        int[][] maze = {
//                  {0, 1, 0, 0, 0, 0}
//                , {0, 1, 0, 1, 1, 0}
//                , {0, 1, 0, 0, 1, 0}
//                , {0, 1, 1, 1, 1, 0}
//                , {0, 1, 0, 0, 0, 0}
//                , {0, 0, 0, 1, 1, 0}};
//        int[][] maze = {{0,1,0,0,0,0},{0,0,1,0,0,0},{0,0,0,1,0,0},{0,0,0,0,1,0},{0,0,0,0,0,0},{1,1,1,1,1,0}};
        int[][] maze = {{0,0,0,0,0,0},{1,1,1,0,1,1},{0,0,0,0,0,0},{1,0,1,1,1,1,},{0,0,0,0,0,0},{1,1,0,1,1,0}};

        System.out.println(solution(maze));
    }

    static int solution(int[][] maze) {
        height = maze.length;
        width = maze[0].length;
        map = maze;

        leftHandRule(0, 0, 1, 0);

        return length;
    }

    //note. 답은 다 나오는데 코드가 별로 맘에 안든다.. 괜찮은건가 이거..?
    static void leftHandRule(int row, int col, int dir, int move) {
        if (row == height - 1 && col == width - 1) {
            length = move;
            return;
        }

        for (int turn = 0; turn < 4; turn++) {
            int currentDirection = (dir + turn + 3) % 4;

            int nextRow = row + rowDir[currentDirection];
            int nextCol = col + colDir[currentDirection];

            if (!isIn(nextRow, nextCol)) continue;
            if (map[nextRow][nextCol] != 0) continue;
            if (length != 0)    return;
            leftHandRule(nextRow, nextCol, currentDirection, move + 1);
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
