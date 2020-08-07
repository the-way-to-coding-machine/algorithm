package org.wtcm.leetcode.q1502;


import java.util.Arrays;

/**
 * an array is called Arithmetic Progression if any consecutive elements' difference is always same.
 */
public class ArithmeticProgression_JY {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]+diff != arr[i+1]) return false;
        }
        return true;
    }
}
