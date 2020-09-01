package org.wtcm.acmicpc.q1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
note. example fibonacci function.
    int fibonacci(int n) {
        if (n == 0) {
            System.out.println(0);
            return 0;
        } else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }
*/
public class Main_JY {
    static int T;
    static int[] dp; // n번째 수의 리프노드 수?
    static int[] fibo;
    static List<Pair> answers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            dp = new int[41];
            fibo = new int[41];
            fibo[1] = 1;
            fibo[2] = 1;
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            int num = Integer.parseInt(br.readLine());
            for (int j = 3; j <= num; j++) {
                dp[j] = dp[j-1] + dp[j-2];
                fibo[j] = fibo[j-1]+fibo[j-2];
            }
            answers.add(new Pair(dp[num]-fibo[num], fibo[num]));
        }
        answers.forEach(System.out::println);
    }
}

class Pair {
    int one;
    int zero;

    public Pair(int zero, int one) {
        this.one = one;
        this.zero = zero;
    }

    @Override
    public String toString() {
        return zero+" "+one;
    }
}