package org.wtcm.nhn;

import java.util.Arrays;
import java.util.Scanner;

class Main2 {
    static int[] heights;
    static int old;
    static int[] finished;

    private static void solution(int day, int width, int[][] blocks) {
        int later = 0;
        finished = new int[width];
        for (int today = 0; today < day; today++) {
            heights = blocks[today];
            old += Arrays.stream(heights).sum();
            for (int i = 0; i < width; i++) finished[i] += heights[i];
            int left = 0;
            for (int cur = 1; cur < width - 1; cur++) {
                if (finished[left] > finished[cur]) { // 왼쪽 벽이 있으면
                    int origin = cur;
                    int right = cur + 1;
                    boolean f = true;
                    while (right < width && finished[right] >= finished[cur]) {
                        cur = right;
                        right++;
                        f = false;
                    }
                    if (f)
                        for (int i = right + 1; i < width; i++)
                            if (finished[right] < finished[i]) {
                                cur = i;
                                break;
                            }

                    Arrays.fill(finished, origin, cur, Math.min(finished[left], finished[cur]));
                    left = cur;
                } else {
                    left = cur;
                }
            }
        }
        later = Arrays.stream(finished).sum();
        System.out.println(later - old);
    }

    private static class InputData {
        int day;
        int width;
        int[][] blocks;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.blocks = new int[inputData.day][inputData.width];
            for (int i = 0; i < inputData.day; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.width; j++) {
                    inputData.blocks[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.day, inputData.width, inputData.blocks);
    }
}