package org.wtcm.acmicpc.q15XXX.q15651;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static int n,m;
    static LinkedList<Integer> seq;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq = new LinkedList<>();
        pick();

        bw.close();
    }

    private static void pick() throws IOException{
        if (seq.size() == m) {
            sb = new StringBuilder();
            for (int num : seq)
                sb.append(num).append(" ");

            bw.write(sb.toString() + "\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            seq.add(i);
            pick();
            seq.pollLast();
        }
    }
}
