package org.wtcm.acmicpc.q15XXX.q15652;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;
    static LinkedList<Integer> seq;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq = new LinkedList<>();
        pick(1);

        bw.close();
    }

    private static void pick(int start) throws IOException {
        if (seq.size() == m) {
            sb = new StringBuilder();
            for (int num : seq)
                sb.append(num).append(" ");
            bw.write(sb.toString()+"\n");

            return;
        }

        for (int i = start; i <= n; i++) {
            seq.add(i);
            pick(i);
            seq.pollLast();
        }
    }
}
