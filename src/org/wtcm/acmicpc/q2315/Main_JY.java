package org.wtcm.acmicpc.q2315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JY {
    static int N, M;
    static int[] D, W, W_ACC;
    static StringTokenizer st;
    static int[][][] dp;
    static final int LEFT = 0, RIGHT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로등 갯수
        M = Integer.parseInt(st.nextToken()) - 1; // 처음 위치

        D = new int[N + 1];
        W = new int[N + 1];
        W_ACC = new int[N + 1];
        dp = new int[N + 1][N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            D[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
            W_ACC[i] = W_ACC[i - 1] + W[i]; // 소비전력의 누적합

        }

//        for (int i = 0; i < N + 1; i++) {
//            for (int j = 0; j < N + 1; j++) {
//                Arrays.fill(dp[i][j], -1);
//            }
//        }
        for (int start = 1; start < N; start++) {
            for (int end = start + 1; end <= N; end++) {
                int outer = W_ACC[N]-W_ACC[end]+W_ACC[start-1];
                dp[start][end][LEFT] = Math
                        .min(
                                dp[start + 1][end][LEFT]+(D[start+1]-D[start])*outer,
                                dp[start + 1][end][RIGHT]+(D[end]-D[start])*outer
                        );
                dp[start][end][RIGHT] = Math
                        .min(
                                dp[start][end - 1][LEFT]+(D[end]-D[start])*outer,
                                dp[start][end - 1][RIGHT]+(D[end]-D[end-1])*outer
                        );
            }
        }
        System.out.println(Math.min(dp[1][N][LEFT], dp[1][N][RIGHT]));
//        System.out.println(move(M, M, 0));
    }

    public static int move(int start, int end, int position) {
        if (start == 1 && end == N) {
            return 0;
        }
        if (dp[start][end][position] != -1) return dp[start][end][position];

        int left, right;
        left = right = Integer.MAX_VALUE;
        int current = position == LEFT ? start : end;
        int outer = W_ACC[N] - W_ACC[end] + W_ACC[start - 1];
        if (start - 1 >= 1) {
            left = move(start - 1, end, LEFT) + (D[current] - D[start - 1]) * outer;
        }
        if (end + 1 <= N) {
            right = move(start, end + 1, RIGHT) + (D[end + 1] - D[current]) * outer;
        }
        return dp[start][end][position] = Math.min(left, right);
    }
}
