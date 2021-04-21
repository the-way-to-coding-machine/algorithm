package org.wtcm.acmicpc.q11XXX.q11724;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        adj = new ArrayList[v+1];
        visited = new boolean[v+1];

        for (int i = 1; i <= v; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int[] ft = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj[ft[0]].add(ft[1]);
            adj[ft[1]].add(ft[0]);
        }
        for (int vertex = 1; vertex <= v; vertex++) {
            if (!visited[vertex]) {
                dfs(vertex);
                cnt++;
            }
        }

        bw.write(cnt+"\n");
        bw.close();
    }

    private static void dfs(int cur) {
        visited[cur] = true;

        for (int next : adj[cur]) {
            if (visited[next]) continue;

            dfs(next);
        }
    }
}
