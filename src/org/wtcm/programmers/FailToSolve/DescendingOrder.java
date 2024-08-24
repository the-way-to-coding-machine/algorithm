package org.wtcm.programmers.FailToSolve;

// 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
// s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
// https://school.programmers.co.kr/learn/courses/30/lessons/12917

import java.util.Arrays;

class DescendingOrder {
    public String solution(String s) {
        int[] asciiArray = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            asciiArray[i] = (int) c;
        }

        int[] ascii = Arrays.stream(asciiArray).sorted().toArray();
        StringBuilder sb = new StringBuilder();

        for (int i = s.length()-1; i >= 0; i--) {
            sb.append((char) i);
        }

        return sb.toString();
    }
}
