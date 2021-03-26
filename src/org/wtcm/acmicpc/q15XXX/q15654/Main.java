package org.wtcm.acmicpc.q15XXX.q15654;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static int n, m;
    static LinkedList<Integer> seq;
    static StringBuilder sb;
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        used = new boolean[n];
        seq = new LinkedList<>();
        pick();

        bw.close();
    }

    private static void pick() throws IOException {
        if (seq.size() == m) {
            sb = new StringBuilder();
            for (int num : seq)
                sb.append(num).append(" ");
            bw.write(sb.toString() + "\n");

            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            seq.add(arr[i]);
            pick();
            used[i] = false;
            seq.pollLast();
        }
    }
}
