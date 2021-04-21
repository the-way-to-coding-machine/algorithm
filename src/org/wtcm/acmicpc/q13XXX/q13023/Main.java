package org.wtcm.acmicpc.q13XXX.q13023;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);  adj[to].add(from);
        }

        for(int start = 0; start < n; start++) {
            visited[start] = true;
            go(start, 1);
            visited[start] = false;
        }

        bw.write(0+"\n");
        bw.close();
    }

    private static void go(int cur, int depth) throws IOException {
        if (depth == 5) {
            bw.write(1+"\n");
            bw.close();
            System.exit(0);
        }

        for (int next : adj[cur]) {
            if (visited[next]) continue;
            visited[next] = true;
            go(next, depth+1);
            visited[next] = false;
        }
    }
}
