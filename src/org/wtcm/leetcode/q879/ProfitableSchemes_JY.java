package org.wtcm.leetcode.q879;

import java.util.Arrays;
import java.util.Map;

public class ProfitableSchemes_JY {
    /*
            G = 5, P = 3
            group = [2, 2]
            profit = [2, 3]

            n번째 crime을 저지르면 profit[n] 을 벌 수 있고, 여기에는 group[n] 명의 사람이 필요하다.
            한번 crime에 참여한 사람은 다른 crime에 참여할 수 없다.

            이때 적어도 P를 벌기 위한 실행할 수 있는 crime scheme을 모두 찾아라.
    * */
    int total, G, P, cnt;
    int[] groups, profits;

    int[][][] cache;

    public int main(int G, int P, int[] group, int[] profit) {
        total = group.length;
        groups = group;
        profits = profit;
        this.P = P;
        this.G = G;

//        bruteForce(0, G, P);

        cache = new int[total][G + 1][P + 1];
        for (int i = 0; i < total; i++)
            for (int j = 0; j <= G; j++)
                for (int k = 0; k <= P; k++)
                    cache[i][j][k] = -1;
//        return cnt;
        return caching(0, G, P);
    }

    /*  note.
            brute force... 가능한 모든 경우의 수를 다 탐색하면서 조건을 만족하는 경우를 count한다.
            할 일 list가 있으면 그냥 한개씩 전부 탐색하면서 do/don't 하는거임.
    * */
    public void bruteForce(int index, int remainedGang, int necessaryProfit) {
        if (index >= total) {
            if (necessaryProfit <= 0 && remainedGang >= 0)
                ++cnt;
            return;
        }

        if (remainedGang < 0)
            return;

        // pick
        if (remainedGang >= groups[index]) {
            bruteForce(index + 1, remainedGang - groups[index], necessaryProfit - profits[index]);
        }
        bruteForce(index + 1, remainedGang, necessaryProfit);

    }

    /*  note.
            위의 brute force에서 cnt를 체크한 경우(조건을 만족하는 경우)에 따로 cache에 저장을 해둔다.
            brute force에서 parameter를 index(몇번째 일인지), G(가용한 member 수), P(필요한 profit)을 가지고 탐색했으므로
            cache또한 이 정보에 따라서 저장해야한다. 가장 간단한 자료구조인 array를 사용하면 편리하며
            cache[index][availableMember][necessaryProfit] 에 해당 값을 저장해놓는다.
    * */
    public int caching(int index, int remainedGang, int necessaryProfit) {
        if (index >= total || remainedGang <= 0) {
            if (remainedGang >= 0 && necessaryProfit <= 0)
                return 1;
            return 0;
        }

        if (cache[index][remainedGang][necessaryProfit] != -1)
            return cache[index][remainedGang][necessaryProfit];

        // 여기서부터는 실제 동작임.
        int commit=0, nocommit=0;
        if (remainedGang >= groups[index])
            commit = caching(index + 1, remainedGang - groups[index], Math.max(0,necessaryProfit - profits[index]));

        nocommit = caching(index + 1, remainedGang, necessaryProfit);
        return cache[index][remainedGang][necessaryProfit] = commit + nocommit;
    }

    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int N = group.length;
        int M = 1_000_000_007;

        int dp[][][] = new int[N + 1][G + 1][P + 1]; // n번째일부터 탐색했을때 g명으로 p를 구하는 경우의 수..?

        dp[0][0][0] = 1;
        for (int i = 1; i <= N; i++) {
            int p = profit[i - 1];
            int g = group[i - 1];
            for (int j = 0; j <= G; j++) {  // 사람 0명일 때부터 G(최댓값)명일때까지...
                for (int k = 0; k <= P; k++) {  // k원을 버는 경우야.. 남은경우야..?
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= g) {
                        dp[i][j][k] += dp[i - 1][j - g][Math.max(0, k - p)] % M;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= G; i++)
            res += dp[N][i][P] % M;

        return res;
    }
}
