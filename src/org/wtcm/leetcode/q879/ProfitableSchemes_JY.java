package org.wtcm.leetcode.q879;

import java.util.Arrays;

public class ProfitableSchemes_JY {
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
    int total, G, P, cnt;
    int[] groups, profits;
    int[][][] cache;

    public int main(int G, int P, int[] group, int[] profit) {
        total = group.length;
        groups = group;
        profits = profit;
        this.P = P;
        this.G = G;

        bruteForce(0, G, P);

//        cache = new int[total][G + 1][P + 1];
//        for (int i = 0; i < total; i++)
//            for (int j = 0; j <= G; j++)
//                for (int k = 0; k <= P; k++)
//                    cache[i][j][k] = -1;
        return cnt;
//        return caching(0, G, P);
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
        if (index >= total) // 모든 crime을 다 탐색하고, 끝났을 때. --> 결과 판정
            return (remainedGang >= 0 && necessaryProfit <= 0) ? 1 : 0; // 조건 만족하면 cnt를 1올리고 아니면 0. (이건 return 받아서 더한다.)

        /* note.
            cache 배열을 -1로 초기화 하지 않고 0으로 두고, 아래의 조건도 '!= 0' 으로 두면
            안되는 경우도 한번 더 탐색하게 된다. cache를 하는 이유는 '되는 경우만' 저장 해놓을 의도가 아니다.
            되던 안되던 한번 탐색 했던 경우는 모두 저장 해놓을 의도이다.
         */
//        else if (cache[index][remainedGang][necessaryProfit] != -1)
//            return cache[index][remainedGang][necessaryProfit];

        else if (remainedGang <= 0) // 이미 남은 인원이 없다면 이번 경우는 x
            return cache[index][remainedGang][necessaryProfit] > -1 ? cache[index][remainedGang][necessaryProfit] : 0;

        /* note.
            dp는 각 subset에 해당하는 문제의 union이 전체 문제의 답이 될 때 쓰는 알고리즘이다.
            고로 caching 함수가 호출될 때 마다 해당 함수(문제)의 답이 될 cnt값을 새로 선언한다.
         */
        int cnt = 0;

        // note.  i 번째 까지가 아니라 '부터'로 생각해야할듯.


        // commit crime if capable
        if (remainedGang >= groups[index])
            cnt += caching(index + 1, remainedGang - groups[index], Math.max(0, necessaryProfit - profits[index]));

        // don't commit crime due to lack of person
        cnt += caching(index + 1, remainedGang, necessaryProfit);

        cache[index][remainedGang][necessaryProfit] = cnt;

        return cnt;
    }
}
