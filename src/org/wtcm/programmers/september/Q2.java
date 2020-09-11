package org.wtcm.programmers.september;

import java.util.Arrays;

/*  note.
        Question.
            1 이상 1000 이하의 n이 주어졌을 때, 높이와 밑변의 길이가 n인 정삼각형에 다음과 같이 숫자를 채워넣을 수 있는 배열을 return해라.
            e.g) n = 4
                        1
                       2 9      answer : [1, 2, 9, 3, 10, 8, 4, 5, 6, 7]
                     3 10 8
                    4 5  6 7
* */

public class Q2 {
    static int n = 1;

    static int[][] square;

    public static void main(String[] args) {
        square = new int[n][n];
        int[] answer = new int[(n * (n + 1)) >> 1];

        int num = 0;
        int count = n;
        int row = 0, col = 0;
        for (int line = 1; line <= n; line++) {
            if (line % 3 == 1) {
                for (int i = 0; i < count; i++)
                    square[row++][col] = ++num;
                row--;
            } else if (line % 3 == 2) {
                for (int i = 0; i < count; i++)
                    square[row][++col] = ++num;
                col--;
            } else {
                for (int i = 0; i < count; i++)
                    square[--row][col--] = ++num;
                row++; col++;
            }
            count--;
        }

        int idx = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (square[i][j] != 0)
                    answer[idx++] = square[i][j];

        Arrays.stream(answer).forEach(System.out::println);
    }
}
