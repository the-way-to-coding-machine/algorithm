package org.wtcm.acmicpc.q13XXX.q13549;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] sd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int len = dijkstra(sd[0], sd[1]);

        bw.write(len + "\n");
        bw.close();
    }

    private static int dijkstra(int src, int des) {
        int[] distance = new int[100001];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        distance[src] = 0;
        q.add(new int[]{src, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[1] > distance[cur[0]]) continue;
            if (cur[0] == des) break;

            if (cur[0] * 2 < 100001 && distance[cur[0] * 2] > cur[1]) {
                distance[cur[0] * 2] = cur[1];
                q.add(new int[]{cur[0] * 2, cur[1]});
            }

            if (cur[0] + 1 < 100001 && distance[cur[0] + 1] > cur[1] + 1) {
                distance[cur[0] + 1] = cur[1] + 1;
                q.add(new int[]{cur[0] + 1, cur[1] + 1});
            }

            if (0 < cur[0] && distance[cur[0] - 1] > cur[1] + 1) {
                distance[cur[0] - 1] = cur[1] + 1;
                q.add(new int[]{cur[0] - 1, cur[1] + 1});
            }
        }

        return distance[des];
    }
}
