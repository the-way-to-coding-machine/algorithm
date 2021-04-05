package org.wtcm.acmicpc.q10XXX.q10971;

import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        visited[0] = true;
        go(0, 0, 0);

        bw.write(min + "\n");
        bw.close();
    }

    private static void go(int idx, int from, int sum) {
        if (idx == n-1) {
            if (map[from][0] != 0)
                min = Math.min(min, sum+map[from][0]);
            return;
        }

        for (int to = 0; to < n; to++) {
            if (visited[to]) continue;
            if (map[from][to] == 0) continue;
            visited[to] = true;
            go(idx + 1, to, sum + map[from][to]);
            visited[to] = false;
        }
    }
}
