package org.wtcm.acmicpc.q14XXX.q14499;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int n, m, x, y, k;
    static int[][] map;
    static int[] cmds;
    static int[] cMove = {1, -1, 0, 0};
    static int[] rMove = {0, 0, -1, 1};
    static int[] dice = {0, 0, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        x = input[2];
        y = input[3];
        k = input[4];
        map = new int[n][m];
        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        cmds = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        int cRow = x, cCol = y;
        for (int cmd : cmds) {
            int nRow = cRow + rMove[cmd - 1];
            int nCol = cCol + cMove[cmd - 1];
            if (!isIn(nRow, nCol)) continue;
            cRow = nRow;    cCol = nCol;
            if (cmd == 1) { // right
                int tmp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = tmp;
            } else if (cmd == 2) { // left
                int tmp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = tmp;
            } else if (cmd == 3) { // up
                int tmp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = tmp;
            } else { // 4 : down
                int tmp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = tmp;
            }

            if (map[nRow][nCol] == 0) {
                map[nRow][nCol] = dice[5];
            } else {
                dice[5] = map[nRow][nCol];
                map[nRow][nCol] = 0;
            }
            bw.write(dice[0] + "\n");
        }
        bw.close();
    }

    private static boolean isIn(int row, int col) {
        return (0 <= row && row < n) && (0 <= col && col < m);
    }

}
