package org.wtcm.acmicpc.q1XXX.q1707;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {
    static ArrayList<Integer>[] adj;
    static int[] group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int[] ve = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj = new ArrayList[ve[0]+1];
            for (int i = 1; i <= ve[0]; i++) adj[i] = new ArrayList<>();
            group = new int[ve[0]+1];

            for (int i = 0; i < ve[1]; i++) {
                int[] ft = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                adj[ft[0]].add(ft[1]);
                adj[ft[1]].add(ft[0]);
            }

            boolean ok = true;
            for (int v = 1; v <= ve[0]; v++) {
                if (group[v] == 0) {
                    group[v] = 1;
                    if (!dfs(v, 1)) {
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

    private static boolean dfs(int cur, int g) {
        for (int next : adj[cur]) {
            if (group[next] == 0) {
                group[next] = 3 - group[cur];
                if (!dfs(next, group[next]))
                    return false;
            } else {
                if (group[cur] == group[next])
                    return false;
            }
        }
        return true;
    }
}
