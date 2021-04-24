package org.wtcm.acmicpc.q14XXX.q14226;

import java.io.*;
import java.util.LinkedList;

public class Main {
    static int n;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        bfs();
        bw.close();
    }

    private static void bfs() throws IOException {
        int ans = 0;
        boolean[][] visited = new boolean[1001][1001];

        visited[1][0] = true;
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == n) {
                bw.write(cur[2]+"\n");
                bw.close();
                return;
            }

            if (0 < cur[0] && cur[0] < 1001) {
                if (!visited[cur[0]][cur[0]]) { // save to clipboard
                    visited[cur[0]][cur[0]] = true;
                    q.add(new int[]{cur[0], cur[0], cur[2] + 1});
                }

                if (0 < cur[1] && cur[0] + cur[1] < 1001) { // load from clipboard
                    if (!visited[cur[0] + cur[1]][cur[1]]) {
                        visited[cur[0] + cur[1]][cur[1]] = true;
                        q.add(new int[]{cur[0] + cur[1], cur[1], cur[2] + 1});
                    }
                }

                if (!visited[cur[0] - 1][cur[1]]) {
                    visited[cur[0] - 1][cur[1]] = true;
                    q.add(new int[]{cur[0] - 1, cur[1], cur[2] + 1});
                }
            }
        }
    }
}
