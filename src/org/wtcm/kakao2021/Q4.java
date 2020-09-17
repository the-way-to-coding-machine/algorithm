package org.wtcm.kakao2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q4 {
    static ArrayList<int[]>[] adjList;
    static int V;

    public static void main(String[] args) {

//        int n=6,s=4,a=6,b=2;
//        int[][] fares = {{4,1,10},{3,5,24},{5,6,2},{3,1,41},{5,1,24},{4,6,50},{2,4,66},{2,3,22},{1,6,25}};

//        int n=7,s=3,a=4,b=1;
//        int[][] fares = {{5,7,9},{4,6,4},{3,6,1},{3,2,3},{2,1,6}};

        int n = 6, s = 4, a = 5, b = 6;
        int[][] fares = {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}};

        System.out.println(solution(n, s, a, b, fares));
    }

    // note. for(1 : i) min(distanceA[i]+distanceB[i]+distance[i]) 가 정답이라는데 이유 모르겠음..ㅎㅎ
    static int solution(int n, int s, int a, int b, int[][] fares) {
        adjList = new ArrayList[n + 1];
        V = n;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n + 1; i++)
            adjList[i] = new ArrayList<>();

        for (int[] link : fares) {
            adjList[link[0]].add(new int[]{link[1], link[2]});
            adjList[link[1]].add(new int[]{link[0], link[2]});
        }

        int[] distanceA = dijkstra(a);
        int[] distanceB = dijkstra(b);
        int[] distance = dijkstra(s);

        // note. 다익스트라는 이제 어느정도 익혔는데 답이 왜 이렇게 구해지는지 ARABOZA
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE
                    | distanceA[i] == Integer.MAX_VALUE
                    | distanceB[i] == Integer.MAX_VALUE)
                continue;

            answer = Math.min(answer, distance[i] + distanceA[i] + distanceB[i]);
        }

        return answer;
    }

    static int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1] - v2[1]);
        int[] distance = new int[V + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new int[]{start, 0});
        distance[start] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] > distance[cur[0]]) continue;

            for (int[] next : adjList[cur[0]]) {
                int newPath = distance[cur[0]] + next[1];
                if (distance[next[0]] > newPath) {
                    distance[next[0]] = newPath;
                    pq.add(new int[]{next[0], newPath});
                }
            }
        }
        return distance;
    }
}
