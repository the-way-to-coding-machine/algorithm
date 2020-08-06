package org.wtcm.leetcode.q1295;

public class FindEvenNumberOfDigits_JY {
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int number : nums) {
            if (countDigit(number) % 2 == 0)
                ++count;
        }
        return count;
    }

    public int countDigit(int num) {
        int cnt = 0;

        for (int i = num; num != 0; num /= 10) {
            ++cnt;
        }
        return cnt;
    }
}
