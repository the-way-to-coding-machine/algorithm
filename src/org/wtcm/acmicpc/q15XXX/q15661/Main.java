package org.wtcm.acmicpc.q15XXX.q15661;


import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] ppl;
    static int n;
    static int min = Integer.MAX_VALUE;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        ppl = new int[n][n];
        selected = new boolean[n];
        for (int i = 0; i < n; i++)
            ppl[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        split(0, 0);

        bw.write(min+"\n");
        bw.close();
    }

    private static void split(int idx, int picked) {

    }

    private static int sum(LinkedList<Integer> team, int size) {
        int sum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum += ppl[team.get(i)][team.get(j)];
            }
        }

        return sum;
    }
}
