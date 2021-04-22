package org.wtcm.acmicpc.q7XXX.q7576;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n, m, rotten, empty;
    static int[] cMove = {1, 0, -1, 0};
    static int[] rMove = {0, 1, 0, -1};
    static LinkedList<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = rc[1];  m = rc[0];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 1) {
                    q.add(new int[]{i, j});
                } else if (cur == -1) empty++;

                map[i][j] = cur;
            }
        }

        int ans = bfs();
        if (n*m - empty > rotten) ans = -1;

        bw.write(ans-1+"\n");
        bw.close();
    }

    private static int bfs() {
        int days = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            days = Math.max(days, map[cur[0]][cur[1]]);
            rotten++;

            for (int dir = 0; dir < 4; dir++) {
                int nRow = cur[0] + rMove[dir];
                int nCol = cur[1] + cMove[dir];
                if (!isIn(nRow, nCol)) continue;
                if (map[nRow][nCol] == 0) {
                    q.add(new int[] {nRow, nCol});
                    map[nRow][nCol] = map[cur[0]][cur[1]]+1;
                }
            }
        }

        return days;
    }

    private static boolean isIn(int row, int col) {
        return (0 <= row && row < n) && (0 <= col && col < m);
    }
}
