package org.wtcm.acmicpc.q18XXX.q18290;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[][] map;
    static int[] cMove = {1, 0, -1, 0};
    static int[] rMove = {0, 1, 0, -1};
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        go(0,0, 0, 0);

        bw.write(max+"\n");
        bw.close();
    }

    private static void go(int sRow, int sCol, int cnt, int sum) {
        if (cnt == k) {
            max = Math.max(sum, max);
            return;
        }

        for (int row = sRow; row < n; row++) { // 이전 행부터
            for (int col = (row == sRow ? sCol : 0); col < m; col++) { // 이전 행의 검사시에는 처음부터 할필요가 업다.
                if (visited[row][col]) continue;
                boolean next = true;

                for (int dir = 0; dir < 4; dir++) { // 사방에 하나라도 갔던게 있으면 --> 인접한 칸.
                    int nRow = row+rMove[dir];
                    int nCol = col+cMove[dir];
                    if (isIn(nRow, nCol) && visited[nRow][nCol])
                        next = false;
                }

                if (next) {
                    visited[row][col] = true;
                    go(row, col, cnt+1, sum+map[row][col]);
                    visited[row][col] = false;
                }
            }
        }
    }

    private static boolean isIn(int row, int col) {
        return (0 <= col && col < m) && (0 <= row && row < n);
    }
}
