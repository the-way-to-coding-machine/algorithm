package org.wtcm.kc2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q3 {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 6;
        int n2 = 4;
        int n3 = 5;

        int[] p = {1, 1, 1, 1, 1, 1};
        int[] p2 = {2, 1, 2, 2};
        int[] p3 = {1, 1, 2, 3, 4};

        int[][] t = {{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}};
        int[][] t2 = {{1, 2}, {1, 3}, {2, 4}};
        int[][] t3 = {{1, 2}, {1, 3}, {1, 4}, {1, 5}};

        int[] ans = s.solution(n, p, t);
        for (int a : ans)
            System.out.print(a + " ");
    }

    private static class Solution {
        static int N;
        static ArrayList<int[]>[] adjList;

        public int[] solution(int n, int[] passenger, int[][] train) {
            int[] answer = {};
            N = n;

            adjList = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++)
                adjList[i] = new ArrayList<>();

            for (int i = 0; i < train.length; i++) {
                adjList[train[i][0]].add(new int[]{train[i][1], -passenger[i]});
                adjList[train[i][1]].add(new int[]{train[i][0], -passenger[i]});
            }

            int max = Integer.MIN_VALUE;
            for (int dest = 2; dest < n; dest++) {
                int cur = -dijkstra(1, dest);
                cur += -dijkstra(dest,1);
                if (max < cur) {
                    answer = new int[]{dest, cur};
                }
            }

            return answer;
        }

        private static int dijkstra(int start, int dest) {
            int[] distance = new int[N + 1];
            PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1] - v2[1]);

            Arrays.fill(distance, Integer.MIN_VALUE);
            distance[start] = 0;
            pq.add(new int[]{start, 0});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();

                if (distance[cur[0]] < cur[1]) continue;
                if (cur[0] == dest) break;

                for (int[] next : adjList[cur[0]]) {
                    int newPath = distance[cur[0]] + next[1];
                    if (distance[next[0]] < newPath) {
                        distance[next[0]] = newPath;
                        pq.add(new int[]{next[0], newPath});
                    }
                }
            }
            return distance[dest];
        }
    }
}
