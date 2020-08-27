package org.wtcm.acmicpc.q1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_JY {
    static int N,M;
    static Pair[] pairs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        pairs = new Pair[M];
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            pairs[i] = new Pair(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        Arrays.sort(pairs, (q1, q2) -> q1.prev - q2.prev == 0 ? q1.next - q2.next : q1.prev - q2.prev);

        System.out.print(pairs[0]);
        for (int i = 1; i < pairs.length; i++)
            System.out.println(" "+ pairs[i]);

    }
}

class Pair {
    int prev;
    int next;

    public Pair(int prev, int next) {this.prev = prev; this.next = next;}

    @Override
    public String toString() {
        return prev + " " + next;
    }
}
