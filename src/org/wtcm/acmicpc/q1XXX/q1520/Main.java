package org.wtcm.acmicpc.q1XXX.q1520;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] memo;

    static int[] cMove = {1, 0, -1, 0};
    static int[] rMove = {0, 1, 0, -1};
    static int r,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        memo = new int[r][c];

        for (int i = 0; i < r; i++)
            Arrays.fill(memo[i], -1);

        for (int row = 0; row < r; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < c; col++)
                map[row][col] = Integer.parseInt(st.nextToken());
        }

        int ans = dfs(0,0);
        bw.write(ans+"\n");
        bw.close();
    }

    private static int dfs(int row, int col) {
        if (memo[row][col] != -1) return memo[row][col];
        if (row == r-1 && col == c-1) return memo[row][col] = 1;

        memo[row][col] = 0;
        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row + rMove[direction];
            int nextCol = col + cMove[direction];

            if (!isIn(nextRow, nextCol)) continue;
            if (map[row][col] <= map[nextRow][nextCol]) continue;
            memo[row][col] += dfs(nextRow, nextCol);
        }
        return memo[row][col];
    }

    private static boolean isIn(int row, int col) {
        return 0 <= row && row < r
                && 0 <= col && col < c;
    }
}
