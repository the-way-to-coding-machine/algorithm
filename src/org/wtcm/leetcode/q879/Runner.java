package org.wtcm.leetcode.q879;

public class Runner {
    public static void main(String[] args) {
        ProfitableSchemes_JY question = new ProfitableSchemes_JY();

//        int G=5, P=3;
//        int[] group = {2,2}, profit={2,3};

//        int G=10, P=5;
//        int[] group = {2,3,5}, profit={6,7,8};

        int G = 1, P = 1;
        int[] group = {1, 1, 1, 1, 2, 2, 1, 2, 1, 1}, profit = {0, 1, 0, 0, 1, 1, 1, 0, 2, 2};
//        System.out.println(question.profitableSchemes(G,P,group,profit));
        System.out.println(question.main(G, P, group, profit));
    }
}
