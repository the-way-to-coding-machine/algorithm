package org.wtcm.acmicpc.q10XXX.q10819;

import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[] seq;
    static boolean[] used;
    static int max = Integer.MIN_VALUE;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ans = new int[n];
        used = new boolean[n];

        go(0);

        bw.write(max+"\n");
        bw.close();
    }

    private static void go(int idx) {
        if (idx == n) {
            max = Math.max(max, makeDiff());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            used[i] = true;
            ans[idx] = seq[i];
            go(idx+1);
            used[i] = false;
        }
    }

    private static int makeDiff() {
        int sum = 0;
        for (int i = 1; i < n; i++)
            sum += Math.abs(ans[i]-ans[i-1]);

        return sum;
    }
}
