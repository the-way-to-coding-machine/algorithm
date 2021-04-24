package org.wtcm.acmicpc.q13XXX.q13913;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] path = bfs(nk[0], nk[1]);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = nk[1]; i != -1; i = path[i])
            ans.add(i);

        Collections.reverse(ans);

        bw.write(ans.size()+"\n");
        for (int p : ans)
            bw.write(p+" ");

        bw.close();
    }

    private static int[] bfs(int src, int dest) {
        int[] path = new int[100001];
        Arrays.fill(path, -1);
        int[] time = new int[100001];
        time[src] = 1;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == dest)
                break;

            for (int i = 0; i < 3; i++) {
                int next = cur;
                if (i == 0) {
                    next += 1;
                } else if (i == 1) {
                    next -= 1;
                } else {
                    next *= 2;
                }
                if (0 > next || next > 100000) continue;
                if (time[next] == 0) {
                    time[next] = time[cur] + 1;
                    path[next] = cur;
                    q.add(next);
                }
            }
        }
        return path;
    }
}
