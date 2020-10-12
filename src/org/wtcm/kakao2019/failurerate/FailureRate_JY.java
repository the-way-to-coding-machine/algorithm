package org.wtcm.kakao2019.failurerate;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FailureRate_JY {
    public static void main(String[] args) {
        //        int N = 5;
//        int[] stages = {2,1,2,6,2,4,3,3};

        int N = 8;
        int[] stages = {1,2,3,4,5,6,7};

//        int N = 4;
//        int[] stages = {4,4,4,4,4};
        Task question = new Task();
        Arrays.stream(question.solution(N, stages)).forEach(System.out::println);
    }
    private static class Task {
        public int[] solution(int N, int[] stages) {
            int[] cache = new int[N + 2]; // cache[i] == stage i 에 있는 사람 수.
            double[] result = new double[N + 1];
            for (int i : stages) {
                cache[i]++;
            }

            for (int failure = 1; failure <= N; failure++) {
                int upper = cache[failure];
                double lower = 0;
                for (int s = failure; s <= N + 1; s++)
                    lower += cache[s];

                lower = lower == 0 ? -1 : lower; // note. 코너케이스를 잘 생각하자..!
                result[failure] = upper / lower;
            }

            // note. StackOverflow에서 본 stream팁..!! 숙지하기1!
            return IntStream.range(1, result.length).boxed().sorted((i, j) -> Double.compare(result[j], result[i]))
                    .mapToInt(ele -> ele).toArray();
        }
    }
}
