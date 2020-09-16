package org.wtcm.practice.shortestpath;

import java.util.*;

public class Dijkstra {
    static int[][] adjMatrix;
    static ArrayList<int[]>[] adjList;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        int[][] linkInfo = {{1, 3, 6}, {1, 4, 3}, {2, 1, 3}, {3, 4, 2}, {4, 3, 1}, {4, 2, 1}, {5, 4, 2,}, {5, 2, 4}};
        matrixBased(5, 8, linkInfo, 5);
        listBased(5, 8, linkInfo, 5);
    }

    static void matrixBased(int vertexNum, int edgeNum, int[][] linkInfo, int start) {
        int[] distance = new int[vertexNum + 1];
        adjMatrix = new int[vertexNum + 1][vertexNum + 1];
        boolean[] visited = new boolean[vertexNum + 1];

        for (int i = 0; i < vertexNum + 1; i++)
            for (int j = 0; j < vertexNum + 1; j++)
                if (i != j) adjMatrix[i][j] = Integer.MAX_VALUE;

        for (int i = 0; i < edgeNum; i++) {
            int[] link = linkInfo[i];
            adjMatrix[link[0]][link[1]] = link[2];
        }

        distance[start] = 0;
        visited[start] = true;
        for (int prev = 1; prev <= vertexNum; prev++) { // note. 이부분을 개선하는게 좋다. 지금은 모든 matrix index를 다 탐색한다.
            for (int cur = 1; cur <= vertexNum; cur++) {
                if (!visited[cur] && adjMatrix[prev][cur] != Integer.MAX_VALUE) {// 방문하지 않았고 연결된 노드
                    distance[cur] = Math.min(distance[cur], distance[prev] + adjMatrix[prev][cur]);
                    visited[cur] = true;
                }
            }
        }

    }

    static void listBased(int vertexNum, int edgeNum, int[][] linkInfo, int start) {
        adjList = new ArrayList[vertexNum + 1];
        int[] distance = new int[vertexNum + 1];
        boolean[] visited = new boolean[vertexNum + 1];

        //note. ArrayList도 내부적으로는 array아닌가..? 이러면 Matrix보다 이점이 있나?
        for (int i = 0; i < edgeNum; i++) {
            int[] link = linkInfo[i];
            adjList[link[0]].add(new int[]{link[1], link[2]});
        }

        visited[1] = true;
        distance[1] = 0;
        for (int prev = 1; prev <= vertexNum; prev++) {
            for (int[] cur : adjList[prev]) { // note. 이렇게 하면 모든 index는 아니고 각 node에 연결된 만큼만 탐색한다. 하지만 이것도 worst는 똑같다.
                if (!visited[cur[0]]) {
                    distance[cur[0]] = Math.min(distance[cur[0]], distance[prev] + cur[1]);
                    visited[cur[0]] = true;
                }
            }

        }
    }

    static void heapBased(int vertexNum, int edgeNum, int[][] linkInfo, int start) { // priority queue
        adjList = new ArrayList[vertexNum];
        int[] distance = new int[vertexNum + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(); // pq에 담는건 {vertex number, distance} 의 pair

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0; // 0이면 끝. visited는 parent같은 역할이다.
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

//            if (cur[0] == dest) // note. 목적지가 있어서 목적지에 도착하면 끝낸다.
//                break;

            for (int[] next : adjList[cur[0]]) {
                if (next[1] + cur[1] < distance[next[0]]) {
                    distance[next[0]] = next[1] + cur[1];
                    pq.add(new int[]{next[0], distance[next[0]]});
                }
            }
        }
    }
}
