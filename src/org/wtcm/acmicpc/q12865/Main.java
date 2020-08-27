package org.wtcm.acmicpc.q12865;

import java.util.Map;
import java.util.stream.IntStream;

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
        /* note. 개념이 안잡힌다... 미치겠군..
            dp[i] --> i번째 물건까지 고려했을 때 최댓값. (X) --> 가방의 limit가 i일때 담기는 최대 value.
            원래는 dp[i][j] 이렇게 2개짜리가 맞는데, 1차원은 이거먼저 되고 하자...
            dp[i][j]는 i번째 물건까지 탐색했을때 담은 무게를 j로 두고, dp[i][j]의 값이 그때의 최대 value다.
        */
        int[][] dp = new int[items + 1][IntStream.of(weight).sum()];
        dp[0][0] = 0;
        for (int i = 1; i <= items; i++) {
            for (int j = 1; j <= limit; j++) {
                dp[i][j] = dp[i - 1][j]; // 이전꺼를 잠시 담았다가
                if (j - weight[i] >= 0)  // note. 왜 이걸 비교하는지 아직 이해안됨.. weight[i]+j <= limit인지 봐야하는거 아닌가..?
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        return dp[items][limit];
    }

    int solution2(int items, int limit, int[] weight, int[] value) {
        int[] dp = new int[items+1];

        dp[0] = 0;

        for (int i = 1; i <= items; i++) {
            for (int j = 1; j <= limit; j++)
                if (j - weight[i] >= 0) // note. 이 조건의 이유는..? 그냥 단순히 index문제때문인거야..?
                    dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
        }
        return dp[limit];
    }
}
