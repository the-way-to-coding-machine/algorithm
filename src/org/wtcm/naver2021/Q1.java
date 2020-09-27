package org.wtcm.naver2021;

import java.text.DecimalFormat;

public class Q1 {
    public static void main(String[] args) {
        int[] p = {5, 4, 7, 2, 0, 6};
        int[] c = {4, 6, 4, 9, 2, 3};

        System.out.println(solution(6, p, c));
    }

    static String solution(int n, int[] p, int[] c) {
        int stock = 0;
        int price = 100;
        int total = 0;

        for (int i = 0; i < n; i++) {
            stock += p[i];
            if (stock - c[i] < 0) {
                if (price == 25) {
                    n = i;
                    break;
                } else {
                    price /= 2;
                }
            } else {
                stock -= c[i];
                total += c[i] * price;
                price = 100;
            }
        }
        total /= n;
        return String.valueOf(total);
    }
}
