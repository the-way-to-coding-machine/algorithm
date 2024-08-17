package org.wtcm.programmers.general;

//함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
//예를들어 n이 118372면 873211을 리턴하면 됩니다.
//https://school.programmers.co.kr/learn/courses/30/lessons/12933


import java.util.Arrays;
import java.util.Collections;

class SortLong {
    public long solution(long n) {
        String[] sn = String.valueOf(n).split("");        // 각 자리수로 찢어 정렬하기 위해 타입 변경 및 공백없이 한글자마다 찢어서 배열에 담음

        Arrays.sort(sn, Collections.reverseOrder());            // 내림차순 정렬. (Collections.naturalOrder());은 오름차순.

        Long answer = Long.parseLong(String.join("",sn));   // 공백없이 모든 글자를 하나로 합쳐 형 변환.

        return answer;
    }

    public static void main(String[] args) {
        SortLong sl = new SortLong();
        sl.solution(1384929);
    }
}