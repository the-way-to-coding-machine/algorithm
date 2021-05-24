package org.wtcm.acmicpc.q16XXX.q16935;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int n,m,r;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];   m = input[1];   r = input[2];

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] ops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] ret;
        for (int op : ops) {
            ret = operation(matrix, op);
            matrix = ret;
        }

        print(matrix);
        bw.close();
    }

    private static void print(int[][] mat) throws IOException {
        for (int[] line : mat) {
            for (int num : line)
                bw.write(num + " ");
            bw.write("\n");
        }
    }

    private static int[][] operation(int[][] mat, int num) {
        int[][] ret;

        int rows = mat.length, cols = mat[0].length;
        switch (num) {
            case 1:
                ret = new int[rows][cols];
                for (int row = 0; row < rows; row++)
                    ret[(rows-1)-row] = mat[row];

                return ret;
            case 2:
                ret = new int[rows][cols];
                for (int col = 0; col < cols; col++)
                    for (int row = 0; row < rows; row++)
                        ret[row][(cols-1)-col] = mat[row][col];

                return ret;

            case 3:
                ret = new int[cols][rows];
                for (int row = 0; row < rows; row++)
                    for (int col = 0; col < cols; col++)
                        ret[col][(rows-1)-row] = mat[row][col];

                return ret;

            case 4:
                ret = new int[cols][rows];
                for (int row = 0; row < rows; row++)
                    for (int col = 0; col < cols; col++)
                        ret[(cols-1)-col][row] = mat[row][col];
                
                return ret;
                
            case 5:
                ret = new int[rows][cols];
                for (int row = 0; row < rows/2; row++) {
                    for (int col = 0; col < cols/2; col++) { // 4
                        ret[row][col] = mat[rows/2+row][col];
                    }

                    for (int col = cols/2; col < cols; col++) { // 1
                        ret[row][col] = mat[row][col-cols/2];
                    }
                }

                for (int row = rows/2; row < rows; row++) {
                    for (int col = 0; col < cols/2; col++) { // 3
                        ret[row][col] = mat[row][col+cols/2];
                    }

                    for (int col = cols/2; col < cols; col++) { // 2
                        ret[row][col] = mat[row-rows/2][col];
                    }
                }
                return ret;

            case 6:
                ret = new int[rows][cols];
                for (int row = 0; row < rows/2; row++) {
                    for (int col = 0; col < cols/2; col++) { // 2
                        ret[row][col] = mat[row][col+cols/2];
                    }

                    for (int col = cols/2; col < cols; col++) { // 3
                        ret[row][col] = mat[row+rows/2][col];
                    }
                }

                for (int row = rows/2; row < rows; row++) {
                    for (int col = 0; col < cols/2; col++) { // 1
                        ret[row][col] = mat[row-rows/2][col];
                    }

                    for (int col = cols/2; col < cols; col++) { // 4
                        ret[row][col] = mat[row][col-cols/2];
                    }
                }
                return ret;

            default:
                return null;
        }
    }
}
