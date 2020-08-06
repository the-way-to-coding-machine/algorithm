package org.wtcm.leetcode.q1104;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PathInZigzagLabelledBinaryTree_JY {
    List<Integer> path = new ArrayList<>();
    int first = 1;

    // 첫숫자 + 끝숫자 더해서 parent값 빼면 reverse한게 나온다... WOW
    public List<Integer> pathInZigZagTree(int label) {
        while (first <= label) first *= 2;

        while (label >= 1) {
            path.add(label);

            first /=2;
            label /= 2;
            label = first / 2 + first - 1 - label;
        }
        Collections.reverse(path);
        return path;
    }
}
