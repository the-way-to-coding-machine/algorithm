package org.wtcm.practice.permutation;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] testData = {1,2,3};
        Permutation permutation = new Permutation(testData);
        List<List<Integer>> result = permutation.lineUp(true);

        result.forEach(System.out::println);
    }
}
