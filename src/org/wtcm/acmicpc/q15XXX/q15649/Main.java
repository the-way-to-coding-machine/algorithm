package org.wtcm.acmicpc.q15XXX.q15649;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N, M;
    static boolean[] used;
    static LinkedList<Integer> seq;

    public static void main(String[] args) {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            used = new boolean[N + 1];

            seq = new LinkedList<>();
            pick();

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void pick() throws IOException {
        if (seq.size() == M) {
            for (int num : seq)
                bw.write(num + " ");
            bw.write("\n");
            bw.flush();
            return;
        }

        for (int num = 1; num <= N; num++) {
            if (used[num]) continue;
            used[num] = true;
            seq.add(num);
            pick();
            used[num] = false;
            seq.pollLast();
        }
    }
}
