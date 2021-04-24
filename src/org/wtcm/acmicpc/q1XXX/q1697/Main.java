package org.wtcm.acmicpc.q1XXX.q1697;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    static int[] nk;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new int[100001];
        int ans = bfs(nk[0], nk[1]);

        bw.write(ans-1+"\n");
        bw.close();
    }

    private static int bfs(int n, int k) {
        visited[n] = 1;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == k)
                break;

            for (int move = 0; move < 3; move++) {
                int next = cur;
                if (move == 0) {
                    next -= 1;
                } else if (move == 1) {
                    next += 1;
                } else {
                    next *= 2;
                }
                if (!(0 <= next && next <= 100000)) continue;
                if (visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    q.add(next);
                }
            }
        }

        return visited[k];
    }
}
