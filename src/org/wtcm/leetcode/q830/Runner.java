package org.wtcm.leetcode.q830;

public class Runner {
    public static void main(String[] args) {
        PositionsOfLargeGroup_JY question = new PositionsOfLargeGroup_JY();
//        String input = "abbxxxxzzy";
//        String input = "abc";
        String input = "abcdddeeeeaabbbcd";
//        String input = "aaa";

        question.largeGroupPositions(input).forEach(System.out::println);
    }
}
