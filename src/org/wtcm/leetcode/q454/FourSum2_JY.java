package org.wtcm.leetcode.q454;

import java.util.HashMap;
import java.util.Objects;

public class FourSum2_JY {
    // note. 틀렸던 문제...ㅠㅠ
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> E = new HashMap<>();
        HashMap<Integer, Integer> F = new HashMap<>();
        int cnt=0;

        for (int a : A)
            for (int b : B)
                if (E.containsKey(a + b)) {
                    int current = E.get(a + b);
                    E.put(a + b, current + 1);
                } else {
                    E.put(a + b, 1);
                }

        for (int c : C)
            for (int d : D)
                if (F.containsKey(c + d)) {
                    int current = F.get(c + d);
                    F.put(c + d, current + 1);
                } else {
                    F.put(c + d, 1);
                }

        for (int e : E.keySet()) {
            if (F.containsKey(-e))
                cnt += (E.get(e) + F.get(-e));
        }
        return cnt;
    }
}
