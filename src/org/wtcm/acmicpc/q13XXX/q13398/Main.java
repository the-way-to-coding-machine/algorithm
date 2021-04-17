package org.wtcm.acmicpc.q13XXX.q13398;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] asc = new int[n];
        int[] desc = new int[n];
        int max = Integer.MIN_VALUE;

        asc[0] = seq[0];
        for (int end = 1; end < n; end++) {
            asc[end] = seq[end];
            if (asc[end] < asc[end-1]+seq[end])
                asc[end] = asc[end-1]+seq[end];

            max = Math.max(max, asc[end]);
        }

        desc[n-1] = seq[n-1];
        for (int start = n-2; start >= 0 ; start--) {
            desc[start] = seq[start];
            if (desc[start] < desc[start+1] + seq[start])
                desc[start] = desc[start+1] + seq[start];
        }

        for (int i = 1; i < n - 1; i++)
            max = Math.max(max, asc[i-1]+desc[i+1]);

        bw.write(max+"\n");
        bw.close();
    }
}
