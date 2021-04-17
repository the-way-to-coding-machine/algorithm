package org.wtcm.acmicpc.q11XXX.q11054;

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

        for (int mid = 0; mid < n; mid++) {
            asc[mid] = 1;
            for (int front = 0; front < mid; front++) {
                if (seq[mid] > seq[front])
                    asc[mid] = Math.max(asc[mid], asc[front] + 1);
            }
        }

        for (int mid = n-1; mid >= 0; mid--) {
            desc[mid] = 1;
            for (int back = mid+1; back < n; back++) {
                if (seq[mid] > seq[back])
                    desc[mid] = Math.max(desc[mid], desc[back]+1);
            }
        }

        for (int i = 0; i < n; i++)
            max = Math.max(max, asc[i]+desc[i]);

        bw.write(max - 1 + "\n");
        bw.close();
    }
}
