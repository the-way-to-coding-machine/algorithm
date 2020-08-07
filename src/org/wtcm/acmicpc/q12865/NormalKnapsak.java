package org.wtcm.acmicpc.q12865;

public class NormalKnapsak {
    int solution(int items, int limit, int[] weight, int[] value) {
        /*
        * item : 4
        * limit : 7
        * weight = [ 6 4 3  5]
        * values = [13 8 6 12]
        *
        * answer : 14
        * */
        // note. 개념이 안잡힌다... 미치겠군..
        //dp[n] --> n번째 물건까지 고려했을 때 최댓값. (X) --> 가방의 limit가 n일때 담기는 최대 value.
        int[] maximumValueWhenCapacity = new int[limit+1];
        for (int n = 1; n <= items; n++)
            for (int j = limit; j - weight[n] >= 0; j--)
                maximumValueWhenCapacity[j] =
                        Math.max(maximumValueWhenCapacity[j], maximumValueWhenCapacity[j - weight[n]] + value[n]);

        return maximumValueWhenCapacity[limit];
    }
}
