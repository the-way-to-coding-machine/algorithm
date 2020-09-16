package org.wtcm.practice.shortestpath;

import java.util.*;

public class Dijkstra {
    int [][] adjMatrix;
    List<List<Vertex>> adjList;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    void matrixBased(int vertexNum, int edgeNum, int[] linkInfo) {
        int[] distance = new int[vertexNum+1];
        adjMatrix = new int[vertexNum+1][vertexNum+1];
        boolean[] visited = new boolean[vertexNum+1];

        for (int i = 0; i < vertexNum + 1; i++)
            for (int j = 0; j < vertexNum + 1; j++)
                if (i != j) adjMatrix[i][j] = Integer.MAX_VALUE;


        for (int i = 0; i < edgeNum; i++)
            adjMatrix[linkInfo[0]][linkInfo[1]] = linkInfo[2];


        for (int i = 1; i <= vertexNum; i++)
            distance[i] = adjMatrix[1][i];

        visited[1] = true;
        for (int prev = 1; prev <= vertexNum; prev++) {
            for (int cur = 1; cur <= vertexNum; cur++) {
                if (!visited[cur] && adjMatrix[prev][cur] != Integer.MAX_VALUE) {
                    distance[cur] = Math.min(distance[cur], distance[prev]+ adjMatrix[prev][cur]);
                    visited[cur] = true;
                }
            }
        }
    }

    void listBased(int vertexNum, int edgeNum, int[] linkInfo) {
        adjList = new ArrayList<>();
        int[] distance = new int[vertexNum+1];

        for (int i = 0; i < vertexNum + 1; i++)
            adjList.add(new ArrayList<Vertex>());

        for (int i = 0; i < edgeNum; i++)
            adjList.add(linkInfo[0], new Vertex());

    }

    void heapBased(int vertexNum, int edgeNum, int[] linkInfo) { // priority queue

    }
}

class Vertex {
    int num;
    int distance;

    public Vertex(int num, int distance) {
        this.num = num;
        this.distance = distance;
    }
}