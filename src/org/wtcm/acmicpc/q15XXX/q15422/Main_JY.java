package org.wtcm.acmicpc.q15XXX.q15422;

import java.io.*;
import java.util.*;

public class Main_JY {
    public static void main(String[] args) throws IOException {
        Task question = new Task();
//        question.solution();
        question.check();
    }
}

class Task {
    int N, M, F, S, T; // city, road, flight, departure, travel to
    ArrayList<Pair>[] adjList;

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());

            adjList[from].add(new Pair(to, weight));
            adjList[to].add(new Pair(from, weight));
        }
        long unused = dijkstra(S, T);

        long used = Long.MAX_VALUE;
        for (int i = 0; i < F; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(new Pair(to, 0));
            used = Math.min(used, dijkstra(S, T));
            adjList[from].remove(adjList[to].size() - 1);
        }
        System.out.println(Math.min(used, unused));
    }

    void check() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < M + F; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (i < M) {
                long weight = Long.parseLong(st.nextToken());
                adjList[from].add(new Pair(to, weight));
                adjList[to].add(new Pair(from, weight));
            } else {
                adjList[from].add(new Pair(to, 0));
            }
        }
        long ans = dijkstra2(S, T);
        System.out.println(ans);
    }

    long dijkstra2(int start, int dest) {
        long[][] distance = new long[N][2];
        long res = 0;
        for (int i = 0; i < N; i++)
            Arrays.fill(distance[i], Long.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        distance[start][1] = 0;
        pq.add(new Pair(start, 0, 1));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (cur.weight > distance[cur.num][cur.available]) continue;

            if (cur.num == dest) {
                res = cur.weight;
                break;
            }

            for (Pair next : adjList[cur.num]) {
                if (cur.available == 1) { // have ticket.
                    if (next.weight == 0) { // air road available
                        if (cur.weight < distance[next.num][0]) {
                            distance[next.num][0] = cur.weight;
                            pq.add(new Pair(next.num, distance[next.num][0], 0));
                        }
                    }
                    if (next.weight != 0) { // just traffic
                        if (cur.weight+next.weight < distance[next.num][cur.available]) {
                            distance[next.num][cur.available] = cur.weight+next.weight;
                            pq.add(new Pair(next.num, distance[next.num][cur.available], cur.available));
                        }
                    }
                } else { // the rests are just road
                    if (cur.weight+next.weight < distance[next.num][cur.available]) {
                        distance[next.num][cur.available] = cur.weight+next.weight;
                        pq.add(new Pair(next.num, distance[next.num][cur.available], cur.available));
                    }
                }
            }
        }
        return res;
    }

    long dijkstra(int start, int dest) {
        long[] distance = new long[N];
        Arrays.fill(distance, Long.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (cur.weight > distance[cur.num]) continue;
            if (cur.num == dest) break;

            for (Pair next : adjList[cur.num]) {
                long nextPath = next.weight + distance[cur.num];
                if (distance[next.num] > nextPath) {
                    distance[next.num] = nextPath;
                    pq.add(new Pair(next.num, nextPath));
                }
            }
        }
        return distance[dest];
    }
}

class Pair implements Comparable<Pair> {
    int num;
    long weight;
    int available;

    Pair(int num, long weight) {
        this.num = num;
        this.weight = weight;
    }

    Pair(int num, long weight, int available) {
        this.num = num;
        this.weight = weight;
        this.available = available;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.weight - o.weight < 0) {
            return -1;
        } else if (this.weight - o.weight > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}