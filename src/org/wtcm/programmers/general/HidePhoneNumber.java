package org.wtcm.programmers.general;

// 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
// 전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로
// 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
// https://school.programmers.co.kr/learn/courses/30/lessons/12948

class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < phone_number.length()-4; i++) {
            sb.append('*');
        }

        sb.append(phone_number.substring(phone_number.length()-4));

        String answer = sb.toString();

        return answer;
    }
}