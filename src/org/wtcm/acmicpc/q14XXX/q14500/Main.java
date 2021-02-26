package org.wtcm.acmicpc.q14XXX.q14500;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][m];

            for (int i = 0; i < n; i++)
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int ans = Integer.MIN_VALUE;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    ans = Math.max(ans, shapeOne(row, col));
                    ans = Math.max(ans, shapeTwo(row, col));
                    ans = Math.max(ans, shapeThree(row, col));
                    ans = Math.max(ans, shapeFour(row, col));
                    ans = Math.max(ans, shapeFive(row, col));
                }
            }

            bw.write(ans + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isIn(int row, int col) {
        return 0 <= col && col < m
                && 0 <= row && row < n;
    }

    private static int shapeOne(int row, int col) {
        int sum = 0;
        for (int c = 0; c < 4; c++) {
            if (isIn(row, col+c)) {
                sum += map[row][col+c];
            } else {
                return -1;
            }
        }
        return sum;
    }

    private static int shapeTwo(int row, int col) {
        int sum = 0;
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 2; c++) {
                if (isIn(row+r, col+c)) {
                    sum += map[row+r][col+c];
                } else {
                    return -1;
                }
            }
        }
        return sum;
    }

    private static int shapeThree(int row, int col) {
        int sum = 0;
        for (int r = 0; r < 3; r++) {
            if (isIn(row+r,col)) {
                sum += map[row+r][col];
            } else {
                return -1;
            }
        }
        if (isIn(row+2, col+1)) {
            sum += map[row+2][col+1];
        } else return -1;

        return sum;
    }

    private static int shapeFour(int row, int col) {
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            row +=i; col +=i;
            for (int r = 0; r < 2; r++) {
                if (isIn(row + r, col)) {
                    sum += map[row + r][col];
                } else return -1;
            }
        }
        return sum;
    }

    private static int shapeFive(int row, int col) {
        int sum = 0;
        for (int c = 0; c < 3; c++) {
            if (isIn(row, col+c)) {
                sum += map[row][col+c];
            } else return -1;
        }
        if (isIn(row+1, col+1)) sum += map[row+1][col+1];
        else return -1;

        return sum;
    }
}
