package org.wtcm.acmicpc.q15XXX.q15486;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] memo;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        int[] cost = new int[n];
        int[] profit = new int[n];
        memo = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            profit[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        while(cost[start] > n) start++;

        int ans = recur(n-start, start, cost, profit);

        bw.write(ans+"\n");
        bw.close();
    }

    private static int recur(int remain, int day, int[] cost, int[] profit) {
        if (day >= n || remain - cost[day] < 0) return 0;
        if (memo[day] != 0) return memo[day];

        int O = profit[day], X = 0;
        O += recur(remain - cost[day], day + cost[day], cost, profit);
        X += recur(remain-1, day+1, cost, profit);

        return memo[day] = Math.max(O, X);
    }
}
