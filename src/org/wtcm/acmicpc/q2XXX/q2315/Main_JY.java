package org.wtcm.acmicpc.q2XXX.q2315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JY {

    public static void main(String[] args) throws IOException {
        Task question = new Task();

//        question.loop();
        question.recursive();
    }
}

class Task {
    static int N, M;
    static int[] D, W, sum;
    static StringTokenizer st;
    static int[][][] dp;
    static final int LEFT = 0, RIGHT = 1;

    Task() throws IOException {
        init();
    }

    void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로등 갯수
        M = Integer.parseInt(st.nextToken()); // 처음 위치

        D = new int[N + 1];
        W = new int[N + 1];
        sum = new int[N + 1];
        dp = new int[N + 1][N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            D[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + W[i]; // 소비전력의 누적합
        }

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                Arrays.fill(dp[i][j], 1000000000);

        dp[M][M][LEFT] = dp[M][M][RIGHT] = 0;
    }

    void loop() {
        for (int distance = 2; distance <= N; distance++) {
            for (int start = 1; start <= N - distance + 1; start++) {
                int end = start + distance - 1;
                int outer1 = sum[N] - sum[end] + sum[start], outer2 = sum[N] - sum[end - 1] + sum[start - 1];

                dp[start][end][LEFT] = Math.min(
                        dp[start + 1][end][LEFT] + (D[start + 1] - D[start]) * outer1
                        , dp[start + 1][end][RIGHT] + (D[end] - D[start]) * outer1);
                dp[start][end][RIGHT] = Math.min(
                        dp[start][end - 1][RIGHT] + (D[end] - D[end - 1]) * outer2
                        , dp[start][end - 1][LEFT] + (D[end] - D[start]) * outer2);
            }
        }
        int min = Math.min(dp[1][N][LEFT], dp[1][N][RIGHT]);
        System.out.println(min);
    }

    void recursive() {
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                Arrays.fill(dp[i][j], -1);

        System.out.println(doRecursive(M,M,0));
    }

    int doRecursive(int start, int end, int position) {
        if (start == 1 && end == N) {
            return 0;
        }
        if (dp[start][end][position] != -1) return dp[start][end][position];

        int left, right;
        left = right = Integer.MAX_VALUE;
        int current = position == LEFT ? start : end;
        int outer = sum[N] - sum[end] + sum[start - 1];
        if (start - 1 >= 1) {
            left = doRecursive(start - 1, end, LEFT) + (D[current] - D[start - 1]) * outer;
        }
        if (end + 1 <= N) {
            right = doRecursive(start, end + 1, RIGHT) + (D[end + 1] - D[current]) * outer;
        }
        return dp[start][end][position] = Math.min(left, right);
    }
}