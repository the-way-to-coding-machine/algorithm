package org.wtcm.acmicpc.q1XXX.q1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main_JY {
    static int N, M;
    static int[] inDegree;
    static List<List<Integer>> graph = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(); // note. 문제에서 작은거부터 풀랬으니 오름차순..

    /* note. 위상정렬
            1. 모든 노드들의 inDegree를 구하고
            2. inDegree가 0인 node부터 시작해서
            3. 자신에게 연결된 노드들의 inDegree를 1씩 낮춘다. (연결된 간선과 자기자신을 지운다고 생각하면 됨.)
            4. inDegree가 0이 된 노드들로부터 위의 과정을 반복한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]); // problem
        M = Integer.parseInt(firstLine[1]); // pairs
        inDegree = new int[N+1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int[] line;
        for (int i = 0; i < M; i++) {
            line = Arrays.stream(br.readLine().split(" ")).mapToInt((Integer::parseInt)).toArray();
            inDegree[line[1]]++;
            graph.get(line[0]).add(line[1]);
        }

        for (int i = 1; i <= N; i++)
            if (inDegree[i] == 0)
                pq.add(i);

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int currentProblem = pq.poll();
            sb.append(currentProblem).append(" ");

            for (int nextProblem : graph.get(currentProblem)) {
                if (--inDegree[nextProblem] == 0)
                    pq.add(nextProblem);
            }
        }
        System.out.println(sb.toString());
    }
}
