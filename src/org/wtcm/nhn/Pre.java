package org.wtcm.nhn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Pre {
    static int N;
    static boolean[][] visit;
    static int[][] map;
    static int[] rowMove = {0,1,0,-1};
    static int[] colMove = {1,0,-1,0};
    private static void solution(int sizeOfMatrix, int[][] matrix) {
        N = sizeOfMatrix;
        visit = new boolean[N][N];
        map = matrix;

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && matrix[i][j] != 0) {
                    answer.add(dfs(i,j));
                }
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        for (Integer integer : answer) System.out.print(integer + " ");

    }

    static int dfs(int row, int col) {
        if (map[row][col] == 0 | visit[row][col]) return 0;

        int cnt = 1;
        visit[row][col] = true;
        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row+rowMove[direction];
            int nextCol = col+colMove[direction];

            if (!isIn(nextRow, nextCol)) continue;
            if (map[nextRow][nextCol] == 0) continue;
            if (visit[nextRow][nextCol]) continue;
            cnt += dfs(nextRow, nextCol);
        }
        return cnt;
    }

    static boolean isIn(int row, int col) {
        return 0 <= row && row < N && col >= 0 && col < N;
    }

    private static class InputData {
        int sizeOfMatrix;
        int[][] matrix;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
            for (int i = 0; i < inputData.sizeOfMatrix; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.sizeOfMatrix; j++) {
                    inputData.matrix[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.sizeOfMatrix, inputData.matrix);
    }
}
