package org.wtcm.nv2021;

/* note. 성냥개비 K개로 만들 수 있는 디지털 시계 모양 숫자(중복가능)

 * */

import java.util.HashMap;

public class Q3 {

    public static void main(String[] args) {
        int k = 11; // 6,11,1;
        Task question = new Task();
        System.out.println(question.solution(k));
    }

    private static class Task {
        int[] numbers = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        HashMap<Integer, Integer> cache = new HashMap<>();

        int solution(int k) {
            int result = recur(k, 1, 1);

            return result;
        }

        int recur(int remain, int currentNumber, int depth) {
            if (cache.get(remain) != null) return cache.get(remain);

            if (remain < 0) return 0;
            else if (remain == 0) return 1;

            int cnt = 0;
            for (int nextNumber = 0; nextNumber <= 9; nextNumber++) {
                if (depth == 1 && nextNumber == 0) continue;
                cnt += recur(remain - numbers[nextNumber], nextNumber, depth+1);
            }
            cache.put(remain, cnt);

            return cache.get(remain);
        }
    }


}
