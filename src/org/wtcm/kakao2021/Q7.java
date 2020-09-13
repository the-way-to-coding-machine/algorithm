package org.wtcm.kakao2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q7 {
    static int[] sales = {14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
    static int[][] links = {{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}};

    static Worker[] total;

    public static void main(String[] args) {
        total = new Worker[sales.length + 1];
        for (int i = 1; i <= sales.length; i++)
            total[i] = new Worker(i, sales[i - 1]);

        for (int[] link : links) {
            total[link[1]].upper = total[link[0]];
            total[link[0]].lower.add(total[link[1]]);
        }

        Arrays.stream(total)
                .filter(it -> it.upper == null)
        ;

        System.out.println("hello");
    }
}

class Worker {
    int number;
    int performance;
    Worker upper;
    List<Worker> lower = new ArrayList<>();

    public Worker(int number, int performance) {
        this.number = number;
        this.performance = performance;
    }
}
