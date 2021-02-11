package org.wtcm.acmicpc.q1XXX.q1949;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_JY {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer>[] map;
    static boolean[] visited;
    static int[][] dp;
    static int[] pop;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        dp = new int[N+1][2];
        pop = new int[N+1];
        map = new List[N+1];
        for (int i = 1; i <= N; i++)
            map[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            pop[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from].add(to);
            map[to].add(from);
        }

        visited[1] = true;
        traverse(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void traverse(int town) {
        for (int linkedTown : map[town]) {
            if (visited[linkedTown]) continue;
            visited[linkedTown] = true;
            traverse(linkedTown);
            dp[town][0] += dp[linkedTown][1];
            dp[town][1] += Math.max(dp[linkedTown][0], dp[linkedTown][1]);
        }
        dp[town][0] += pop[town];
    }
}

/*

7
1000 3000 4000 1000 2000 2000 7000
1 2
2 3
4 3
4 5
6 2
6 7

* */