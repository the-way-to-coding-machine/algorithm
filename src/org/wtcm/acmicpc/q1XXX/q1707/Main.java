package org.wtcm.acmicpc.q1XXX.q1707;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    static int[] group;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int[] ve = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj = new ArrayList[ve[0]+1];
            group = new int[ve[0]+1];
            for (int i = 1; i <= ve[0]; i++)
                adj[i] = new ArrayList<>();

            for (int i = 0; i < ve[1]; i++) {
                int[] ft = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                adj[ft[0]].add(ft[1]);
                adj[ft[1]].add(ft[0]);
            }

            boolean ok = true;
            for (int v = 1; v <= ve[0]; v++) {
                if (group[v] == 0) {
                    if (!bfs(v)) {
                        ok = false;
                        break;
                    }
                }
            }

            String ans = ok ? "YES\n" : "NO\n";
            bw.write(ans);
        }
        bw.close();
    }

    private static boolean bfs(int root) {
        group[root] = 1;

        LinkedList<Integer> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adj[cur]) {
                if (group[next] == 0) {
                    group[next] = 3 - group[cur];
                    q.add(next);
                } else {
                    if (group[next] == group[cur])
                        return false;
                }
            }
        }
        return true;
    }
}
