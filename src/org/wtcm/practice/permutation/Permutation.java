package org.wtcm.practice.permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutation {
    private int[] originArr;
    private List<Integer> originList;
    private int size;
    private List<List<Integer>> total;

    public Permutation(int[] arr) {
        this.originArr = arr;
        this.originList = IntStream.of(arr).boxed().collect(Collectors.toList());
        this.size = arr.length;
        this.total = new ArrayList<>();
    }

    public List<List<Integer>> lineUp(int num, boolean duplicate) {
        LinkedList<Integer> result = new LinkedList<>();

        if (duplicate) innerDuplicateLineUp(result, size, num);
        else {
            boolean[] check = new boolean[size];
            innerLineUp(result, check, size, num);
        }

        return this.total;
    }

    public List<List<Integer>> lineUp(boolean duplicate) {
        LinkedList<Integer> result = new LinkedList<>();

        if (duplicate) innerDuplicateLineUp(result, size, size);
        else {
            boolean[] check = new boolean[size];
            innerLineUp(result, check, size, size);
        }
        return this.total;
    }

    private void innerLineUp(LinkedList<Integer> result, boolean[] check, int total, int toPick) {
        if (result.size() == toPick) {
            this.total.add((List<Integer>) result.clone());
            return;
        }

        for (int idx = 0; idx < total; idx++) {
            if (!check[idx]) {
                result.add(originArr[idx]);
                check[idx] = true;
                innerLineUp(result, check, total, toPick);
                check[idx] = false;
                result.removeLast();
            }
        }
    }

    private void innerDuplicateLineUp(LinkedList<Integer> result, int total, int toPick) {
        if (result.size() == toPick) {
            this.total.add((List<Integer>) result.clone());
            return;
        }

        for (int idx = 0; idx < total; idx++) {
            result.add(originArr[idx]);
            innerDuplicateLineUp(result, total, toPick);
            result.removeLast();
        }
    }

    int[][] cache;
    public int dpPermutation(int n, int r) {
        cache = new int[n][n];
        return innerDpPermutation(n, r);
    }

    private int innerDpPermutation(int n, int r) {
        if (cache[n][r] != 0) return cache[n][r];
        if (r == 0) return 1;
        return cache[n][r] = n * innerDpPermutation(n - 1, r - 1);
    }

}
