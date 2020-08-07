package org.wtcm.leetcode.q879;

public class Runner {
    public static void main(String[] args) {
        ProfitableSchemes question = new ProfitableSchemes();

//        int G=5, P=3;
//        int[] group = {2,2}, profit={2,3};

        int G=10, P=5;
        int[] group = {2,3,5}, profit={6,7,8};

        System.out.println(question.profitableSchemes(G,P,group,profit));
    }
}
