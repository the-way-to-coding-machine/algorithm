package org.wtcm.leetcode.q879;

public class ProfitableSchemes {
    /*
            G = 5, P = 3
            group = [2, 2]
            profit = [2, 3]

            n번째 crime을 저지르면 profit[n] 을 벌 수 있고, 여기에는 group[n] 명의 사람이 필요하다.
            한번 crime에 참여한 사람은 다른 crime에 참여할 수 없다.

            이때 적어도 P를 벌기 위한 실행할 수 있는 crime scheme을 모두 찾아라.


            profit[i]를 하기 위한 cost == group[i]
            dp
    * */

    /*
            note. 딱 내가 잘 못하는 전형적인 dp 유형이다...
    * */
    public int profitableSchemes(int budget, int P, int[] costs, int[] profits) {
        int modulo = 1_000_000_007;
        int totalWork = costs.length, res = 0;
        int[][][] result = new int[totalWork+1][budget+1][P+1]; // [team번호][참여인원][얻은 수익..?]

        result[0][0][0] = 1; // 1번부터 시작한다.
        //result[workNum][money][earn]
        for (int workNum = 1; workNum <= totalWork; workNum++) {
            int cost = costs[workNum-1], profit = profits[workNum-1]; // i번째 팀이 i번째 번째 수익을 얻을 때.
            for (int money = 0; money <= budget; money++) {
                for (int earn = 0; earn <= P; earn++) {
                    result[workNum][money][earn] = result[workNum-1][money][earn];
                    if (money >= cost) { // j가 g보다 큰 경우가 어떤 경우지..
                        result[workNum][money][earn] = (result[workNum][money][earn] + result[workNum-1][money-cost][Math.max(0,earn-profit)]) % modulo;
                    }
                }
            }
        }
        for (int i = 0; i <= budget; i++) {
            res = (res+result[totalWork][i][P]) % modulo;
        }
        return res;
    }
}
