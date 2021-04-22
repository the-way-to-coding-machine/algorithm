package org.wtcm.acmicpc.q2XXX.q2178;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    static int n,m;
    static int[][] map;
    static int[][] visited;
    static int[] cMove = {1,0,-1,0};
    static int[] rMove = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];   m = input[1];
        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int min = bfs(0, 0);

        bw.write(min+"\n");
        bw.close();
    }

    private static int bfs(int row, int col) {
        visited[row][col] = 1;
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n-1 && cur[1] == m-1)
                break;

            for (int dir = 0; dir < 4; dir++) {
                int nRow = cur[0] + rMove[dir];
                int nCol = cur[1] + cMove[dir];
                if (!isIn(nRow, nCol)) continue;
                if (map[nRow][nCol] == 0) continue;
                if (visited[nRow][nCol] != 0) continue;
                visited[nRow][nCol] = visited[cur[0]][cur[1]]+1;
                q.add(new int[] {nRow, nCol});
            }
        }
        return visited[n-1][m-1];
    }

    private static boolean isIn(int row, int col) {
        return (0 <= row && row < n) && (0 <= col && col < m);
    }
}
