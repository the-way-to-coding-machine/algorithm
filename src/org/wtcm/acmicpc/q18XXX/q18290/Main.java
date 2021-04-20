package org.wtcm.acmicpc.q18XXX.q18290;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] rMove = {0,1,0,-1};
    static int[] cMove = {1,0,-1,0};
    static int n, m, k;
    static int[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] first = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = first[0];
        m = first[1];
        k = first[2];
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < first[0]; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        go(0, 0, k, 0);

        bw.write(max+"\n");
        bw.close();
    }

    private static void go(int curRow, int curCol, int left, int sum) {
        if (left == 0) {
            max = Math.max(max, sum);
            return;
        }

        for (int row = curRow; row < n; row++) {
            for (int col = (row == curRow ? curCol : 0); col < m; col++) {
                if (visited[row][col]) continue;

                boolean valid = true;
                for (int dir = 0; dir < 4; dir++) {
                    int nRow = row+rMove[dir];
                    int nCol = col+cMove[dir];

                    if (!isIn(nRow, nCol)) continue;
                    if (visited[nRow][nCol]) valid = false;
                }

                if (valid) {
                    visited[row][col] = true;
                    go(row, col, left-1, sum+map[row][col]);
                    visited[row][col] = false;
                }
            }
        }
    }

    private static boolean isIn(int row, int col) {
        return 0 <= row && row < n && 0 <= col && col < m;
    }
}
