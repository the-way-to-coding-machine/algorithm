package org.wtcm.acmicpc.q1XXX.q1912;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n]; // dp[n] --> n번째 수로 끝나는 sequence중 max값.
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp[0] = arr[0];
        int max = arr[0];
        for (int cur = 1; cur < n; cur++) {
            dp[cur] = Math.max(arr[cur], dp[cur-1]+arr[cur]);
            max = Math.max(max, dp[cur]);
        }
        bw.write(max+"\n");
        bw.close();
    }
}
