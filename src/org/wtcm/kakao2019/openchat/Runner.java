package org.wtcm.kakao2019.openchat;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        OpenChattingRoom_JY question = new OpenChattingRoom_JY();

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        Arrays.stream(question.solution(record)).forEach(System.out::println);
    }
}
