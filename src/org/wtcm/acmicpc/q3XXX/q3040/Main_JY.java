package org.wtcm.acmicpc.q3XXX.q3040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main_JY {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[9];
        int ex = 0;
        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            ex += nums[i];
        }
        ex -= 100;

        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (nums[i]+nums[j] == ex) {
                    final int fake1 = nums[i];
                    final int fake2 = nums[j];
                    IntStream.of(nums).filter(num -> num != fake1 && num != fake2).forEach(System.out::println);
                }
            }
        }
    }
}
/*
7
8
10
13
15
19
20
23
25
* */