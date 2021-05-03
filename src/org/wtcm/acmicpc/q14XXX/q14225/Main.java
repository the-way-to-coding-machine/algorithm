package org.wtcm.acmicpc.q14XXX.q14225;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] valid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        valid = new boolean[100000 * n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            valid[num] = true;
        }

        pick(0, 0);

        for (int i = 1; i < valid.length; i++) {
            if (!valid[i]) {
                bw.write(i + "\n");
                break;
            }
        }

        bw.close();
    }

    private static void pick(int idx, int sum) {
        if (idx == n) {
            valid[sum] = true;
            return;
        }

        pick(idx + 1, sum + arr[idx]);
        pick(idx + 1, sum);

    }
}
