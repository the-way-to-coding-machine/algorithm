package org.wtcm.acmicpc.q3XXX.q3085;

import java.io.*;

public class Main {
    static String[][] candies;
    static int n;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++)
                candies[i] = br.readLine().split(" ");

            int max = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (col + 1 < n) {
                        swap(row, col, row, col + 1);
                        max = Math.max(max, checkCol(row, col, col + 1));
                        swap(row, col, row, col + 1);
                    }
                    if (row + 1 < n) {
                        swap(row, col, row + 1, col);
                        max = Math.max(max, checkRow(row, col, row + 1));
                        swap(row, col, row + 1, col);
                    }
                }
            }
            bw.write(max + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int checkRow(int xRow, int xCol, int yRow) {
        int cnt = 1;
        int max = 0;

        for (int col = 1; col < n; col++) {
            if (candies[xRow][col].equals(candies[xRow][col-1]))
                cnt++;
            else {
                max = Math.max(max, cnt);
                cnt = 1;
            }
        }
        cnt = 1;
        for (int col = 1; col < n; col++) {
            if (candies[yRow][col].equals(candies[yRow][col-1]))
                cnt++;
            else {
                max = Math.max(max, cnt);
                cnt = 1;
            }
        }
        cnt = 1;
        for (int row = 1; row < n; row++) {
            if (candies[row][xCol].equals(candies[row-1][xCol]))
                cnt++;
            else {
                max = Math.max(max, cnt);
                cnt = 1;
            }
        }
        return max;
    }

    private static void swap(int xRow, int xCol, int yRow, int yCol) {
        String tmp = candies[xRow][xCol];
        candies[xRow][xCol] = candies[yRow][yCol];
        candies[yRow][yCol] = tmp;
    }

    private static int checkCol(int xRow, int xCol, int yCol) {
        int cnt = 1;
        int max = 0;


    }
}
