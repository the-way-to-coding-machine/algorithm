package org.wtcm.acmicpc.q14XXX.q14501;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] memo;
    static int[] time;
    static int[] profit;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        time = new int[n];
        profit = new int[n];
        memo = new int[n]; // memo[n] --> n 일부터 시작했을때 최대 이익익
       Arrays.fill(memo, -1);

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            profit[i] = Integer.parseInt(st.nextToken());
        }

        int max = recur(n, 0);
        bw.write(max+"\n");
        bw.close();
    }

    private static int recur(int remain, int today) {
        if (today >= n) return 0;
        if (memo[today] != -1) return memo[today];

        int O = 0, X = 0;
        if (today + time[today] <= n) {
            O = profit[today];
            O += recur(remain-time[today], today+time[today]);
        }
        X += recur(remain-1, today+1);

        return memo[today] = Math.max(O, X);
    }
}
