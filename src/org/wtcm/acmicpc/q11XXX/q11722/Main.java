package org.wtcm.acmicpc.q11XXX.q11722;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] lis = new int[n+1];
        lis[0] = Integer.MIN_VALUE;

        int idx = 0;
        for (int cur = 0; cur < n; cur++) {
            if (lis[idx] < -arr[cur])
                lis[++idx] = -arr[cur];
            else {
                int position = binarySearch(idx, -arr[cur], lis);
                lis[position] = -arr[cur];
            }
        }

        bw.write(idx+"\n");
        bw.close();
    }

    private static int binarySearch(int end, int target, int[] list) {
        int mid, start = 0;

        while (start < end) {
            mid = (start + end) >> 1;
            if (list[mid] < target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}