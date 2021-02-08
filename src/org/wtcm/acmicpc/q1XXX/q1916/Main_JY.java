package org.wtcm.acmicpc.q1XXX.q1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_JY {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static List<int[]>[] adjList;
    static int dep, arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjList = new ArrayList[M+1];

        for (int i = 1; i <= M; i++)
            adjList[i] = new ArrayList<>();

        for (int bus = 1; bus <= M; bus++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjList[input[0]].add(new int[] {input[1], input[2]});
        }

        String[] problem = br.readLine().split(" ");
        dep = Integer.parseInt(problem[0]);
        arr = Integer.parseInt(problem[1]);

        System.out.println(dijkstra());
    }

    static int dijkstra() {
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1] - v2[1]);

        pq.add(new int[]{dep, 0});
        distance[dep] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] > distance[cur[0]]) continue;
            if (cur[0] == arr) break;

            for (int[] next : adjList[cur[0]]) {
                int nextPath = next[1] + distance[cur[0]];
                if (distance[next[0]] > nextPath) {
                    distance[next[0]] = nextPath;
                    pq.add(new int[] {next[0], nextPath});
                }
            }
        }
        return distance[arr];
    }
}
