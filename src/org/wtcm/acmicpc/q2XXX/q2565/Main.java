package org.wtcm.acmicpc.q2XXX.q2565;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<int[]> A = new ArrayList<>();

        for (int i = 0; i < n; i++)
            A.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());

        A.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] arr = new int[n];
        int idx = 0;
        for (int[] conn : A)
            arr[idx++] = conn[1];



    }
}
