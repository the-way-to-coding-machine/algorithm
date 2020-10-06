package org.wtcm.naver2021;

/* note. 성냥개비 K개로 만들 수 있는 디지털 시계 모양 숫자(중복가능)

 * */

import java.util.Arrays;
import java.util.LinkedList;

public class Q3 {
    static int[] numbers = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static int K;
    static int answer;

    public static void main(String[] args) {
        int k = 20; // 6,11,1;
        solution(k);
    }

    static void solution(int k) {
        K = k;
        for (int pick = 1; pick <= 9; pick++) {
            if (K < 2 * pick) continue;
//            int[] result = new int[pick];
//            Arrays.fill(result, -1);
//            combination(result, numbers, numbers.length, pick, 0, 0);
            LinkedList<Integer> result = new LinkedList<>();
            permutation(result, 10, pick);
        }
        System.out.println(answer);
    }

    static void combination(int[] resultArray, int[] srcArray, int total, int toPick, int srcIdx, int resultIdx) {
        if (toPick == 0) {
            if (Arrays.stream(resultArray).sum() == K) {
                int cnt = resultArray.length;
                int tmp = 1;
                while (cnt > 0) {
                    tmp *= cnt--;
                }
                answer += tmp;
            }
            return;
        }

        if (srcIdx >= total) return;
        resultArray[resultIdx] = srcArray[srcIdx];

        combination(resultArray, srcArray, total, toPick - 1, srcIdx, resultIdx + 1);
        combination(resultArray, srcArray, total, toPick, srcIdx + 1, resultIdx);
    }

    static void permutation(LinkedList<Integer> resultList, int total, int toPick) {
        if (resultList.size() == toPick) {
            if (resultList.get(0) == 0 && toPick != 1) return;
            int sum = 0;
            for (int idx : resultList) sum += numbers[idx];
            if (sum == K) answer++;
            return;
        }

        for (int srcIdx = 0; srcIdx < total; srcIdx++) {
            resultList.add(srcIdx);
            permutation(resultList, total, toPick);
            resultList.removeLast();
        }
    }
}
