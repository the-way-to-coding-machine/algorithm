package org.wtcm.acmicpc.q7XXX.q7562;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    static int l;
    static int[][] map;
    static int[][] visited;
    static int[] src;
    static int[] dest;
    static int[] cMove = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] rMove = {-2, -1, 1, 2, 2, 1, -1, -2};
    static LinkedList<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
        while (t-- > 0) {
            l = Integer.parseInt(br.readLine());
            src = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dest = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            q.clear();
            map = new int[l][l];
            visited = new int[l][l];
            int ans = bfs();

            bw.write(ans - 1 + "\n");
        }
        bw.close();
    }

    private static int bfs() {
        visited[src[0]][src[1]] = 1;
        q.add(new int[]{src[0], src[1]});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == dest[0] && cur[1] == dest[1])
                break;

            for (int dir = 0; dir < 8; dir++) {
                int nRow = cur[0] + rMove[dir];
                int nCol = cur[1] + cMove[dir];

                if (!isIn(nRow, nCol)) continue;
                if (visited[nRow][nCol] == 0) {
                    visited[nRow][nCol] = visited[cur[0]][cur[1]] + 1;
                    q.add(new int[]{nRow, nCol});
                }
            }
        }

        return visited[dest[0]][dest[1]];
    }

    private static boolean isIn(int row, int col) {
        return (0 <= row && row < l) && (0 <= col && col < l);
    }
}
