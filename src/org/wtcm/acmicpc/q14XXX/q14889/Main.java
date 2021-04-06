package org.wtcm.acmicpc.q14XXX.q14889;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static int n;
    static int[][] ppl;
    static int min = Integer.MAX_VALUE;
    static LinkedList<Integer> team1;
    static LinkedList<Integer> team2;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        ppl = new int[n][n];
        for (int i = 0; i < n; i++)
            ppl[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        team1 = new LinkedList<>();
        team2 = new LinkedList<>();

//        split(0);
        bw.write(min+"\n");
        bw.close();
    }

    private static void split(int idx) {
        if (idx == n) {
            if (team1.size() == n/2 && team2.size() == n/2)
                min = Math.min(min, Math.abs(sum(team1) - sum(team2)));

            return;
        }

        if (team1.size() < n/2) {
            team1.add(idx);
            split(idx + 1);
            team1.removeLast();
        }

        if (team2.size() < n/2) {
            team2.add(idx);
            split(idx + 1);
            team2.removeLast();
        }
    }

    private static int sum(LinkedList<Integer> team) {
        int sum = 0;
        for (int i = 0; i < n/2; i++)
            for (int j = 0; j < n/2; j++)
                sum += ppl[team.get(i)][team.get(j)];

        return sum;
    }
}
