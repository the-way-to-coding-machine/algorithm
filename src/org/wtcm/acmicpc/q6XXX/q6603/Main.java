package org.wtcm.acmicpc.q6XXX.q6603;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] arr;
    static int[] ans = new int[6];
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (;;) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            if (len == 0) break;

            arr = new int[len];
            for (int i = 0; i < len; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);
            used = new boolean[len];
            pick(0, 0);
            bw.write("\n");
        }
        bw.close();
    }

    private static void pick(int idx, int start) throws IOException {
        if (idx == 6) {
            for (int num : ans) bw.write(num + " ");
            bw.write("\n");
            bw.flush();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            ans[idx] = arr[i];
            pick(idx + 1, i);
            used[i] = false;
        }
    }
}
