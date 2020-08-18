package org.wtcm.kakao2019.openchat;

import java.util.*;

public class OpenChattingRoom_JY {
    public String[] solution(String[] record) {
        String enter = "님이 들어왔습니다.";
        String leave = "님이 나갔습니다.";
        HashMap<String, String> userMap = new LinkedHashMap<>(); // uid, name
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] msg = record[i].split(" ");

            if (!msg[0].equals("Leave")) {
                userMap.put(msg[1], msg[2]);
            }
        }

        for (int i = 0; i < record.length; i++) {
            String[] msg = record[i].split(" ");

            if (msg[0].equals("Leave")) {
                answer.add(userMap.get(msg[1])+leave);
            } else if(msg[0].equals("Enter")) {
                answer.add(userMap.get(msg[1])+enter);
            }
        }

        return answer.toArray(new String[answer.size()]);
    }
}
