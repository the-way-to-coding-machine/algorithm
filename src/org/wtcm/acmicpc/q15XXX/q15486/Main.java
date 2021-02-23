package org.wtcm.acmicpc.q15XXX.q15486;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        int[] cost = new int[n];
        int[] profit = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            profit[i] = Integer.parseInt(st.nextToken());
        }
        /** Top Down - Recursive**/
        TopDown recur = new TopDown(n);
        int recurAns = recur.solution(n, 0, cost, profit);

        /** Bottom Up - Iterative **/
//        DownUp iter = new DownUp(n, profit, cost);
//        int iterAns = iter.solution();

        bw.write(recurAns+"\n");
//        bw.write(iterAns+"\n");
        bw.close();
    }

    private static class TopDown {
        int[] memo;

        TopDown(int n) {
            memo = new int[n];
            Arrays.fill(memo, -1);
        }

        private int solution(int remain, int day, int[] cost, int[] profit) {
            if (day >= n) return 0;
            if (memo[day] != -1) return memo[day];

            int O = 0, X = 0;
            if (day + cost[day] <= n) {
                O = profit[day];
                O += solution(remain-cost[day], day+cost[day], cost, profit);
            }
            X += solution(remain-1, day+1, cost, profit);

            return memo[day] = Math.max(O, X);
        }
    }

    private static class DownUp {
        int[] dp;
        int[] cost, profit;

        DownUp(int n, int[] profit, int[] cost) {
            dp = new int[n+1];
            this.cost = cost;
            this.profit = profit;
        }

        // dp[day] 는 'day' 전날 까지의 최대 이익(day에 일한 돈은 day+cost[day]날에 받는다.)
        private int solution() {
            int max = 0;
            for (int day = 0; day <= n; day++) {
                max = Math.max(dp[day], max);
                if (day < n && day + cost[day] < n+1) {
                    dp[day+cost[day]] = Math.max(max + profit[day], dp[day + cost[day]]);
                }
            }
            return max;
        }
    }
}