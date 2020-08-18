package org.wtcm.kakao2019.failurerate;

import java.util.Arrays;

public class FailureRate_JY {
    public int[] solution(int N, int[] stages) {
        int[] cache = new int[N+2]; // cache[i] == stage i 에 있는 사람 수.
        double[] result = new double[N+1];
        for (int i : stages) {
            cache[i]++;
        }

        for (int failure = 1; failure <= N; failure++) {
            int upper = cache[failure];
            double lower = 0;
            for (int s = failure; s <= N+1; s++)
                lower += cache[s];
            result[failure] = upper/lower;
        }
        return null;
    }
}
