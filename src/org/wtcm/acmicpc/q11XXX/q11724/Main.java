package org.wtcm.acmicpc.q11XXX.q11724;

import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        rank = new int[v+1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < e; i++) {
            int[] ft = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            union(ft[0], ft[1]);
        }

        Set<Integer> roots = new HashSet<>();
        for (int i = 1; i <= v; i++)
            roots.add(findRoot(i));

        bw.write(roots.size()+"\n");
        bw.close();
    }

    private static void union(int n1, int n2) {
        n1 = findRoot(n1);
        n2 = findRoot(n2);

        if (n1 == n2) return;

        if (rank[n1] > rank[n2])
            parent[n2] = n1;
        else {
            parent[n1] = n2;

            if (rank[n1] == rank[n2])
                rank[n1]++;
        }
    }

    private static int findRoot(int node) {
        if (parent[node] == node)
            return node;

        return parent[node] = findRoot(parent[node]);
    }
}
