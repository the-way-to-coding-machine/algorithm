package org.wtcm.leetcode;

public class FriendsRequest_JY {
    public int solution(int[] people) { // 제약 조건을 잘 보자! 사람 수는 20,000명이고, 가능한 age는 120이다.
        int answer = 0;
        int[] count = new int[121];

        for (int age : people) count[age]++;

        for (int ageA = 0; ageA <= 120; ageA++) {
            if (count[ageA] == 0) continue;
            for (int ageB = 0; ageB <= 120; ageB++) {
                if (count[ageB] == 0) continue;
                if (available(ageA, ageB))
                    answer += count[ageA] * count[ageB];
                if (ageA == ageB) answer -= count[ageA];
            }
        }
        return answer;
    }

    public boolean available(int a, int b) {
        if (a < b) return false;
        if (b <= 0.5 * a + 7) return false;
        if ((b > 100) && (a < 100)) return false;

        return true;
    }

}

//          /* first try - time exceed */
//
//    public int solution(int[] ages) {
//        int answer = 0;
//
//        for (int i = 0; i < ages.length; i++) {
//            for (int j = 0; j < ages.length; j++) {
//                if (i == j) continue;
//                if (available(ages[i], ages[j])) {
//                    answer++;
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    public boolean available(int a, int b) {
//        if (b <= (0.5 * a + 7))
//            return false;
//        if (b > a)
//            return false;
//        if ((b > 100) && (a < 100))
//            return false;
//
//        return true;
//    }

//      /* 이게 정답인데 솔직히 뭐가 다른지 모르겠다... */
//
//    public int numFriendRequests(int[] ages) {
//        int[] count = new int[121];
//        for (int age: ages) count[age]++;
//
//        int ans = 0;
//        for (int ageA = 0; ageA <= 120; ageA++) {
//            int countA = count[ageA];
//            for (int ageB = 0; ageB <= 120; ageB++) {
//                int countB = count[ageB];
//                if (ageA * 0.5 + 7 >= ageB) continue;
//                if (ageA < ageB) continue;
//                if (ageA < 100 && 100 < ageB) continue;
//                ans += countA * countB;
//                if (ageA == ageB) ans -= countA;
//            }
//        }
//
//        return ans;
//    }

