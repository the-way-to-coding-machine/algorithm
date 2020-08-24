package org.wtcm.acmicpc.q1399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] k = new int[N];
        int[] m = new int[N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            k[i] = Integer.parseInt(line[0]);
            m[i] = Integer.parseInt(line[1]);
        }
    }
}
