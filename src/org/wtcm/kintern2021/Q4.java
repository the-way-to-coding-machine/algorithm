package org.wtcm.kintern2021;

import java.util.ArrayList;

public class Q4 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n1 = 3, s1 = 1, e1 = 3;
        int[][] road1 = {{1, 2, 2}, {3, 2, 3}};
        int[] t1 = {2};

        int n2 = 4, s2 = 1, e2 = 4;
        int[][] road2 = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
        int[] t2 = {2,3};

        System.out.println(s.solution(n2, s2, e2, road2, t2));
    }

    private static class Solution {
        static ArrayList<int[]>[] map;
        static int[][] r;
        static int min = Integer.MAX_VALUE, dest, total;
        static boolean[][] visitedEdge;
        static boolean[] visitedNode;
        static boolean[] isTrap;
        public int solution(int n, int start, int end, int[][] roads, int[] traps) {
            map = new ArrayList[n+1];
            isTrap = new boolean[n+1];
            r = roads;
            total = n;
            for (int node : traps)
                isTrap[node] = true;

            for (int i = 1; i <= n; i++)
                map[i] = new ArrayList<>();

            visitedEdge = new boolean[n+1][n+1];
            visitedNode = new boolean[n+1];
            for (int[] road : roads) {
                int from = road[0];
                int to = road[1];
                int cost = road[2];
                map[from].add(new int[] {to, cost});
            }

            dest = end;
            dfs(start, 0);

            return min;
        }

        private static void dfs(int cur, int cost) {
            if (cur == dest) {
                min = Math.min(min, cost);
                return;
            }

            visitedNode[cur] = true;

            if (isTrap[cur]) {
                reverse(cur);
            }

            for (int[] next : map[cur]) {
                if (visitedNode[next[0]])
                    if (visitedEdge[cur][next[0]])
                        continue;
                visitedEdge[cur][next[0]] = true;
                dfs(next[0], cost+next[1]);
            }
        }

        private static void reverse(int node) {
            map = new ArrayList[total+1];
            for (int i = 1; i <= total; i++)
                map[i] = new ArrayList<>();

            for (int[] road : r) {
                int from = road[0];
                int to = road[1];
                int cost = road[2];
                if (from == node || to == node) {
                    int tmp = from;
                    from = to;
                    to = tmp;
                }
                map[from].add(new int[] {to, cost});
            }
        }
    }
}
