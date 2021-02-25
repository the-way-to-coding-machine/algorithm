package org.wtcm.acmicpc.q3XXX.q3085;

import java.io.*;

public class Main {
    static char[][] candies;
    static int n;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            n = Integer.parseInt(br.readLine());
            candies = new char[n][n];
            for (int i = 0; i < n; i++)
                candies[i] = br.readLine().toCharArray();

            int max = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (col + 1 < n) {
                        swap(row, col, row, col + 1);
                        max = Math.max(max, check(row, col, row,col + 1));
                        swap(row, col, row, col + 1);
                    }
                    if (row + 1 < n) {
                        swap(row, col, row + 1, col);
                        max = Math.max(max, check(row, col, row+1, col));
                        swap(row, col, row + 1, col);
                    }
                }
            }
            bw.write(max + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void swap(int xRow, int xCol, int yRow, int yCol) {
        char tmp = candies[xRow][xCol];
        candies[xRow][xCol] = candies[yRow][yCol];
        candies[yRow][yCol] = tmp;
    }

    private static int check(int startRow, int startCol, int endRow, int endCol) {
        int max = 0;
        for (int row = startRow; row <= endRow; row++) {
            int cnt = 1;
            for (int col = 1; col < n; col++) {
                if(candies[row][col] == candies[row][col-1])
                    cnt++;
                else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        for (int col = startCol; col <= endCol; col++) {
            int cnt = 1;
            for (int row = 1; row < n; row++) {
                if (candies[row][col] == candies[row-1][col])
                    cnt++;
                else {
                    cnt = 1;
                }
                max = Math.max(max, cnt); // 얘를 else 안에 넣었더니 TC는 됐는데 틀렸다...
            }
        }

        return max;
    }
}
