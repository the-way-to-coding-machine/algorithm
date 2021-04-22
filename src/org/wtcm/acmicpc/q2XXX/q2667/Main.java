package org.wtcm.acmicpc.q2XXX.q2667;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    static int[] cMove = {1, 0, -1, 0};
    static int[] rMove = {0, 1, 0, -1};
    static int[][] map;
    static int n;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int cnt = 0;
        ArrayList<Integer> area = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (!visited[row][col] && map[row][col] == 1) {
                    area.add(bfs(row, col));
                    cnt++;
                }
            }
        }
        Collections.sort(area);
        bw.write(cnt+"\n");
        for (int s : area)
            bw.write(s+"\n");

        bw.close();
    }

    private static int bfs(int row, int col) {
        visited[row][col] = true;
        int cnt = 1;

        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nRow = cur[0] + rMove[dir];
                int nCol = cur[1] + cMove[dir];
                if (!isIn(nRow, nCol)) continue;
                if (visited[nRow][nCol]) continue;
                if (map[nRow][nCol] == 1) {
                    visited[nRow][nCol] = true;
                    q.add(new int[] {nRow, nCol});
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static boolean isIn(int row, int col) {
        return (0 <= row && row < n) && (0 <= col && col < n);
    }

}
