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
    int total, G, P, cnt;
    int[] groups, profits;

    public int main(int G, int P, int[] group, int[] profit) {
        total = group.length;
        groups = group;
        profits = profit;
        this.P = P;
        this.G = G;

        recur(0, G, P);

        return cnt;
    }

    public void recur(int index, int remainedGang, int necessaryProfit) {
        if (index >= total) {
            if (necessaryProfit <= 0 && remainedGang >= 0)
                ++cnt;
            return;
        }

        if (remainedGang < 0)
            return;

        // pick
        if (remainedGang > groups[index]) {
            recur(index + 1, remainedGang - groups[index], necessaryProfit - profits[index]);
        }
        recur(index + 1, remainedGang, necessaryProfit);

    }
}
