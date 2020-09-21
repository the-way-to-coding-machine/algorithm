package org.wtcm.acmicpc.q2XXX.q2252;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main_JY {
    static int[] inDegree;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static List<List<Integer>> graph = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        inDegree = new int[NM[0]+1];
        for (int i = 0; i < NM[0]+1; i++)
            graph.add(new LinkedList<>());

        for (int i = 0; i < NM[1]; i++) {
            int[] order = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            inDegree[order[1]]++;
            graph.get(order[0]).add(order[1]);
        }

        for (int i = 1; i <= NM[0]; i++)
            if (inDegree[i] == 0)
                pq.add(i);


        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int currentStudent = pq.poll();
            sb.append(currentStudent).append(" ");
            for (int nextStudent : graph.get(currentStudent)) {
                if (--inDegree[nextStudent] == 0)
                    pq.add(nextStudent);
            }
        }
        System.out.println(sb.toString());
    }
}