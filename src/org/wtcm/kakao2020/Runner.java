package org.wtcm.kakao2020;

public class Runner {
    public static void main(String[] args) {
        StringCompression_JY question = new StringCompression_JY();

//        String input = "aabbacccd";
//        String input = "ababcdcdababcdcd";
//        String input = "abcabcdede";
        String input = "ababcdcdababcdcd";
//        String input = "abcabcabcabcdededededede";
//        String input = "xababcdcdababcdcd";


        System.out.println(question.solution(input));
    }
}
