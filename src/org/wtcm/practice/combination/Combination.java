package org.wtcm.practice.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Combination {
    private int[] originArr;
    private int size;
    private List<List<Integer>> total;
    private boolean[] picked;

    public Combination(int[] originArr) {
        this.originArr = originArr;
        this.size = originArr.length;
    }

    public List<List<Integer>> pick(int num, boolean duplicate) {
        this.total = new ArrayList<>();
        int[] result = new int[num];
        if (duplicate) duplicateCombination(result, size, num, 0, 0);
        else combination(result, size, num, 0, 0);

        return this.total;
    }

    public int[][] pick(int num, int sum, boolean duplicate) {
        return null;
    }

    public int[][] pick(int num, boolean duplicate, Predicate condition) {
        return null;
    }

    public void innerPick(int startIdx, int toPick, boolean[] picked) {
        if (toPick == 0) {
            collect();
            return;
        }

        for (int currentIdx = startIdx; currentIdx < size; currentIdx++) {
            picked[currentIdx] = true;
            innerPick(currentIdx+1, toPick-1, picked);
            picked[currentIdx] = false;
        }
    }

    private void collect() {
        List<Integer> pair = new ArrayList<>();
        for (int idx = 0; idx < size; idx++) {
            if (picked[idx])
                pair.add(originArr[idx]);
        }
        total.add(pair);
    }

    private void duplicateCombination(int[] resultArray, int total, int toPick, int pickIdx, int arrIdx) {
        if (toPick == 0) {
            this.total.add(IntStream.of(resultArray).boxed().collect(Collectors.toList()));
            return;
        }
        if (arrIdx == total) return;

        resultArray[pickIdx] = originArr[arrIdx];
        duplicateCombination(resultArray, total, toPick-1, pickIdx+1, arrIdx);
        duplicateCombination(resultArray, total, toPick, pickIdx, arrIdx+1);
    }

    private void combination(int[] resultArray, int total, int toPick, int pickIdx, int arrIdx) {
        if (toPick == 0) {
            this.total.add(IntStream.of(resultArray).boxed().collect(Collectors.toList()));
            return;
        }
        if (arrIdx == total) return;

        resultArray[pickIdx] = originArr[arrIdx];
        combination(resultArray, total, toPick-1, pickIdx+1, arrIdx+1);
        combination(resultArray, total, toPick, pickIdx, arrIdx+1);
    }
}
