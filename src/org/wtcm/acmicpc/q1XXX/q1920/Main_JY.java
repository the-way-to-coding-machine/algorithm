package org.wtcm.acmicpc.q1XXX.q1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_JY {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] ns;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        ns = new int[N];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            ns[i] = Integer.parseInt(s1[i]);

        Arrays.sort(ns);
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] s2 = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            sb.append(exists(Integer.parseInt(s2[i])));
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static int exists(int number) {
        int start = 0;
        int end = ns.length;
        int mid = end;

        while(start < end) {
            mid = (start+end) >> 1;
            if(ns[mid] < number) {
                start = mid+1;
            } else if (ns[mid] > number) {
                end = mid;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
