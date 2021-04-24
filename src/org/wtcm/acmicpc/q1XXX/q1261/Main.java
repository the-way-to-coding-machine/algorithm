package org.wtcm.acmicpc.q1XXX.q1261;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int n,m;
    static int[][] map;
    static int[][] cost;
    static int[] cMove = {1,0,-1,0};
    static int[] rMove = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[1];   m = input[0];

        map = new int[n][m];
        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        cost = new int[n][m];

        int ans = bfs();

        bw.write(ans+"\n");
        bw.close();
    }

    private static int bfs() {
        int ans = 0;

        for (int i = 0; i < n; i++)
            Arrays.fill(cost[i], Integer.MAX_VALUE);

        cost[0][0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((n1, n2) -> n1[2] - n2[2]);
        q.add(new int[] {0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[2] > cost[cur[0]][cur[1]])
                continue;

            if (cur[0] == n-1 && cur[1] == m-1) {
                ans = cur[2];
                break;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nRow = cur[0] + rMove[dir];
                int nCol = cur[1] + cMove[dir];
                if (!isIn(nRow, nCol)) continue;
                int nCost = cur[2] + map[nRow][nCol];
                if (cost[nRow][nCol] > nCost) {
                    cost[nRow][nCol] = nCost;
                    q.add(new int[] {nRow, nCol, nCost});
                }
            }
        }

        return ans;
    }

    private static boolean isIn(int row, int col) {
        return (0 <= row && row < n) && (0 <= col && col < m);
    }
}
