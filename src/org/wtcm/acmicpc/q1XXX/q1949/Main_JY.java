package org.wtcm.acmicpc.q1XXX.q1949;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main_JY {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<int[]>[] adjList;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] ns = new int[N];

        int i = 0;
        for (String population : br.readLine().split(" "))
            ns[i++] = Integer.parseInt(population);

        adjList = new List[N+1];
        for (i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();

        for (i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            adjList[Integer.parseInt(input[0])].add(new int[] {Integer.parseInt(input[1]), ns[i]});
        }


    }
}

/*

7
1000 3000 4000 1000 2000 2000 7000
1 2
2 3
4 3
4 5
6 2
6 7

* */