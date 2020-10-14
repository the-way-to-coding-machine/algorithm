package org.wtcm.acmicpc.q1XXX.q1167;

import java.io.*;
import java.util.*;

public class Main_JY {
    public static void main(String[] args) throws IOException {
        OutputWriter out = new OutputWriter(System.out);

        Task question = new Task();
        question.solution(out);
        out.close();
    }
}

class Task {
    int V;
    ArrayList<int[]>[] tree;
    void solution(OutputWriter out) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V+1];

        for (int i = 1; i <= V; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            String[] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            for (int idx = 1; idx < line.length-1; idx += 2) {
                int to = Integer.parseInt(line[idx]);
                int length = Integer.parseInt(line[idx+1]);

                tree[from].add(new int[] {to, -length});
            }
        }
        int[] distance = dijkstra(1);
        int min=Integer.MAX_VALUE, idx=0;
        for (int i = 2; i < distance.length; i++) {
            if (min > distance[i]) {
                min = distance[i];
                idx = i;
            }
        }
        distance = dijkstra(idx);
        min=Integer.MAX_VALUE;
        for (int i = 1; i < distance.length; i++) {
            if (min > distance[i]) {
                min = distance[i];
            }
        }
        out.print(-min);
    }

    int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1] - v2[1]);
        int[] distance = new int[V+1];
        Arrays.fill(distance, Integer.MIN_VALUE);

        pq.add(new int[] {start, 0});
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] > distance[cur[0]]) continue;

            for (int[] next : tree[cur[0]]) {
                int newLength = distance[cur[0]] + next[1];
                if (distance[next[0]] < newLength) {
                    distance[next[0]] = newLength;
                    pq.add(new int[] { next[0], newLength});
                }
            }
        }
        return distance;
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(int i) {
        writer.print(i);
    }

    public void print(long i) {
        writer.print(i);
    }

    public void println(Object... objects) {
        int len = objects.length;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
        writer.println();
    }

    public void close() {
        writer.close();
    }
}
