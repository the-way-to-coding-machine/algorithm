package org.wtcm.acmicpc.q1XXX.q1693;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int n;
    static int maxColors;
    static int[][] dp;
    static int[] parent;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        maxColors = (int) (Math.log10(n)/Math.log10(2));
        dp = new int[n+1][maxColors+1];
        parent = new int[n+1];
        tree = new List[n+1];
        for (int i = 1; i <= n ; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            tree[input[0]].add(input[1]);
            tree[input[1]].add(input[0]);
        }

        int ans = Integer.MAX_VALUE;
        for (int color = 1; color <= maxColors; color++)
            ans = Math.min(ans, paint(1, color));

        bw.write(ans+"\n");
        bw.close();
    }

    static int paint(int currentNode, int color) {
        if (dp[currentNode][color] != 0) return dp[currentNode][color];

        int sum = 0;
        for (int child : tree[currentNode]) {
            if (parent[currentNode] == child) continue;
            int sub = Integer.MAX_VALUE;
            for (int c = 1; c <= maxColors; c++) {
                if (color == c) continue;
                parent[child] = currentNode;
                sub = Math.min(sub, paint(child, c));
            }
            sum += sub;
        }
        return dp[currentNode][color] = sum+color;
    }
}
