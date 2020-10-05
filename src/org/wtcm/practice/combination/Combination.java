package org.wtcm.practice.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Combination {
    private int[] array;
    private int size;
    private List<List<Integer>> total;
    private boolean[] picked;

    public Combination(int[] array) {
        this.array = array;
        this.size = array.length;
    }

    public List<List<Integer>> pick(int num, boolean duplicate) {
        total = new ArrayList<>();
        picked = new boolean[size];
//        innerPick(0, num, picked);
        int[] recomb = new int[num];
        recomb(recomb, size, num, 0, 0);
        return total;
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
                pair.add(array[idx]);
        }
        total.add(pair);
    }

    public void recomb(int[] recombArr, int n, int r, int idx, int target) {
        if (r == 0) {
            for (int i = 0; i < recombArr.length; i++) {
                System.out.print(recombArr[i]+" ");
            }
            System.out.println("");
            return;
        }
        if (target == n) return;

        recombArr[idx] = target;
        recomb(recombArr, n, r-1, idx+1, target);
        recomb(recombArr, n, r, idx, target+1);
    }
}
