package org.wtcm.acmicpc;

import java.util.Scanner;

public class Virus2606_JY {
    int[] parent;

    public int solution() {
        int answer = 0;
        Scanner sc = new Scanner(System.in);

        int computers = sc.nextInt();
        int edges = sc.nextInt();
        parent = new int[computers+1];

        for (int i = 1; i <= computers; i++) {
            parent[i] = i;
        }

        for (int idx = 0; idx < edges; idx++) {
            String[] edge = sc.nextLine().split(" ");
            union(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
        }

        for (int com = 2; com <= computers; com++) {
            if (parent[com] == parent[1])   answer++;
        }
        return answer;
    }

    int findRoot(int computer) {
        if (parent[computer] == computer)
            return computer;

        return findRoot(parent[computer]);
    }

    void union(int c1, int c2) {
        int c1Root = findRoot(c1);
        int c2Root = findRoot(c2);

        parent[c2Root] = c1Root;
    }
}
