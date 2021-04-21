package org.wtcm.acmicpc.q11XXX.q11724;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main3 {
    static ArrayList<Integer>[] adj;
    static int v, e;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ve = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        v = ve[0];
        e = ve[1];
        adj = new ArrayList[v+1];
        for (int i = 1; i <= v; i++)
            adj[i] = new ArrayList<>();

        visited = new boolean[v + 1];

        for (int i = 0; i < e; i++) {
            int[] ft = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj[ft[0]].add(ft[1]);
            adj[ft[1]].add(ft[0]);
        }

        int cnt = 0;
        for (int vertex = 1; vertex <= v; vertex++) {
            if (!visited[vertex]) {
                bfs(vertex);
                cnt++;
            }
        }

        bw.write(cnt+"\n");
        bw.close();
    }

    private static void bfs(int root) {
        visited[root] = true;

        LinkedList<Integer> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adj[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                q.add(next);
            }
        }
    }
}
