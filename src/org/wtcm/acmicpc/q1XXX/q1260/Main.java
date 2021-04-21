package org.wtcm.acmicpc.q1XXX.q1260;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        adj = new ArrayList[firstLine[0]+1];
        visited = new boolean[firstLine[0]+1];
        for (int i = 1; i <= firstLine[0]; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < firstLine[1]; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        sb = new StringBuilder();
        dfs(firstLine[2]);
        bw.write(sb.toString()+"\n");

        sb = new StringBuilder();
        Arrays.fill(visited, false);
        bfs(firstLine[2]);
        bw.write(sb.toString()+"\n");

        bw.close();
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        sb.append(cur).append(' ');

        Collections.sort(adj[cur]);
        for (int next : adj[cur]) {
            if (visited[next]) continue;
            dfs(next);
        }
    }

    private static void bfs(int cur) {
        visited[cur] = true;

        LinkedList<Integer> q = new LinkedList<>();
        q.add(cur);

        while (!q.isEmpty()) {
            int parent = q.poll();
            sb.append(parent).append(' ');

            for (int child : adj[parent]) {
                if (visited[child]) continue;
                visited[child] = true;
                q.add(child);
            }
        }
    }
}
