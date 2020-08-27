package org.wtcm.acmicpc.q1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_JY {
    static int[] xMove = {1,0,-1,0};
    static int[] yMove = {0,1,0,-1};
    static int [][] map, visited;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        M = Integer.parseInt(firstLine[0]);
        N = Integer.parseInt(firstLine[1]);

        map = new int[M][N];
        visited = new int[M][N];
        for (int i = 0; i < M; i++)
            Arrays.fill(visited[i], -1);

        for (int i = 0; i < M; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        System.out.println(dfs(0,0));
    }

    static int dfs(int y, int x) {
        if (x == N-1 && y == M-1)
            return 1;

        if (visited[y][x] == -1) { // note. caching을 신박하게 사용했네..
            int cur = map[y][x];
            visited[y][x] = 0;
            for (int direction = 0; direction < 4; direction++) {
                int nextX = x + xMove[direction];
                int nextY = y + yMove[direction];
                if (nextX >= N || nextX < 0 || nextY >= M || nextY < 0) continue;
                if (cur <= map[nextY][nextX]) continue;
                visited[y][x] += dfs(nextY, nextX);
            }
        }
        return visited[y][x];
    }
}
