package org.wtcm.acmicpc.q1XXX.q1003;

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
    static int[] dp; // note. dp는 0의 갯수
    static List<Pair> answers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            dp = new int[42];
            dp[0] = 1;
            for (int j = 2; j <= 41; j++) {
                dp[j] = dp[j-1]+ dp[j-2];
            }
            answers.add(new Pair(dp[num], dp[num+1]));
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