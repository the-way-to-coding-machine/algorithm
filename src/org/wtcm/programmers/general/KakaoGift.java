package org.wtcm.programmers.general;

import java.util.Arrays;
import java.util.stream.Stream;

class KakaoGift {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Stream<String> giftsStream = Stream.of(gifts);
        Stream<String> flatGifts = giftsStream.flatMap(s-> Arrays.stream(s.split(" ")));
        String[] giftsArray = flatGifts.toArray(s -> new String[s]);

        int[] giftsCoefficient = new int[friends.length];

        for(int i = 0; i < friends.length; i++) {
            int give = 0;
            int receive = 0;

            for(int j = 0; j < giftsArray.length; j+=2) {
                if(friends[i].equals(giftsArray[j])) {
                    give++;
                }

            }

            for(int j = 1; j < giftsArray.length; j+=2) {
                if(friends[i].equals(giftsArray[j])) {
                    receive++;
                }
            }

            giftsCoefficient[i] = give - receive;
        }

        int maxGC = 0;
        for(Integer g : giftsCoefficient) {
            if(g > maxGC) {
                maxGC = g;
            }
        }

        int giftKing = 0;
        for(Integer g : giftsCoefficient) {
            if(g == maxGC) {
                giftKing++;
            }
        }

        if(giftKing == friends.length) {
            return answer;
        }

        answer = friends.length - giftKing;

        return answer;
    }

    public static void main(String[] args) {
        KakaoGift kg = new KakaoGift();
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(kg.solution(friends, gifts));
    }
}
