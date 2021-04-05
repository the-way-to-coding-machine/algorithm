package org.wtcm.acmicpc.q10XXX.q10974;

import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[] ans;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        ans = new int[n];
        used = new boolean[n];
        go(0);
        bw.close();
    }

    private static void go(int idx) throws IOException {
        if (idx == n) {
            for (int num : ans)
                bw.write(num + " ");
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            used[i] = true;
            ans[idx] = i + 1;
            go(idx + 1);
            used[i] = false;
        }
    }
}
