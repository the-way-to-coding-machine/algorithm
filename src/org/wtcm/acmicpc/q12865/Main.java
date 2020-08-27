package org.wtcm.acmicpc.q12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
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
//
//    public static void main(String[] args) throws IOException { // note. 메모리 초과
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] firstLine = br.readLine().split(" ");
//        int N = Integer.parseInt(firstLine[0]);
//        int K = Integer.parseInt(firstLine[1]);
//
//        int[] weights = new int[N+1];
//        int[] values = new int[N+1];
//        for (int i = 0; i < N; i++) {
//            String[] line = br.readLine().split(" ");
//            weights[i] = Integer.parseInt(line[0]);
//            values[i] = Integer.parseInt(line[1]);
//        }
//
//        int[][] dp = new int[N + 1][IntStream.of(weights).sum()];
//        dp[0][0] = 0;
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= K; j++) {
//                dp[i][j] = dp[i - 1][j]; // 이전꺼를 잠시 담았다가
//                if (j - weights[i] >= 0)  // note. 왜 이걸 비교하는지 아직 이해안됨.. weight[i]+j <= limit인지 봐야하는거 아닌가..?
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weights[i]] + values[i]);
//            }
//        }
//        System.out.println(dp[N][K]);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);

        int[] weights = new int[N+1];
        int[] values = new int[N+1];
        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            weights[i] = Integer.parseInt(line[0]);
            values[i] = Integer.parseInt(line[1]);
        }

        int[] dp = new int[K+1];
        for (int i = 1; i <= N; i++) {// n번째 물건까지 탐색했을 때, k만큼의 무게 여유가 있을때의 최대 value.
            for (int j = K; j >= 1; j--)
                if (j - weights[i] >= 0) // k는 '무게'의 limit이니깐 i번째 아이템의 '무게'가 limit보다 커서는 안된다.
                    dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
        }
        System.out.println(dp[K]);
    }
}
