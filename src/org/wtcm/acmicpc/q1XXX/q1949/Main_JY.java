package org.wtcm.acmicpc.q1XXX.q1949;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_JY {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer>[] map;
    static boolean[] visited;
    static int[][] dp;
    static int[] pop;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new List[N+1];
        visited = new boolean[N+1];
        Arrays.fill(map, new ArrayList<>());
        dp = new int[N+1][N+1];

        pop = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N-1; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[input[0]].add(input[1]);
            map[input[1]].add(input[0]);
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
        dp[town][0] += pop[town-1];
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