package org.wtcm.acmicpc.q14XXX.q14503;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] cMove = {0, 1, 0, -1};
    static int[] rMove = {-1, 0, 1, 0};
    static boolean[][] visited;
    static int[][] map;
    static int cnt;
    static boolean done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0], m = input[1];
        map = new int[n][m];
        visited = new boolean[n][m];

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = input[0], c = input[1], d = input[2];
        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        go(r, c, d);

        bw.write(cnt + "\n");
        bw.close();
    }

    private static void go(int row, int col, int curDir) {
        if (done) return;

        if (!visited[row][col])
            cnt++;

        visited[row][col] = true;

        boolean cleaned = false;
        for (int dir = 3; dir >= 0; dir--) {
            int next = (curDir + dir) % 4;
            int nRow = row + rMove[next];
            int nCol = col + cMove[next];
            if (!isIn(nRow, nCol)) continue;
            if (!visited[nRow][nCol] && map[nRow][nCol] == 0) {
                go(nRow, nCol, next);
                cleaned = true;
            }
        }

        if (!cleaned) {
            int back = (curDir + 2) % 4;
            int pRow = row + rMove[back];
            int pCol = col + cMove[back];
            if (isIn(pRow, pCol) && map[pRow][pCol] == 0)
                go(pRow, pCol, curDir);
            else done = true;
        }
    }

    private static boolean isIn(int row, int col) {
        return (0 <= row && row < map.length) && (0 <= col && col < map[0].length);
    }
}
