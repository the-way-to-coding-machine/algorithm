package org.wtcm.practice.combination;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] testData = {1,2,3,4};
        Combination combination = new Combination(testData);

        List<List<Integer>> result = combination.pick(2, true);
//
//        result.forEach(System.out::println);
    }
}
