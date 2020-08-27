package org.wtcm.acmicpc.q2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_JY {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int computers = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        parent = new int[computers+1];

        for (int i = 1; i <= computers; i++) {
            parent[i] = i;
        }

        for (int idx = 0; idx < edges; idx++) {
            String[] edge = br.readLine().split(" ");
            union(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
        }

        for (int com = 2; com <= computers; com++) {
            if (parent[com] == parent[1])   answer++;
        }
        System.out.println(answer);
    }

    static int findRoot(int computer) {
        if (parent[computer] == computer)
            return computer;

        return findRoot(parent[computer]);
    }

    static void union(int c1, int c2) {
        int c1Root = findRoot(c1);
        int c2Root = findRoot(c2);

        parent[c2Root] = c1Root;
    }
}
