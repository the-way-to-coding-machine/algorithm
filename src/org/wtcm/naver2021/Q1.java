package org.wtcm.naver2021;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Sol sol = new Sol();
//        String[] q = {"abc","bca","dbe"};
        String[] qq = {"gr","sd","rg"};
        int[] ans = sol.solution(qq);

        Arrays.stream(ans).forEach(System.out::println);
    }

    private static class Sol {
        public int[] solution(String[] S) {
            int[] res = {};
            int m = S[0].length();
            HashMap<Character, int[]> memo = new HashMap<>();
            //      alphabet, idx
            for (int str = 0; str < S.length; str++) {
                for (int idx = 0; idx < m; idx++) {
                    char cur = S[str].charAt(idx);
                    if (memo.containsKey(cur)) {
                        if (memo.get(cur)[1] == idx) {
                            res = new int[3];
                            res[0] = memo.get(cur)[0];
                            res[1] = str;
                            res[2] = idx;
                        }
                    } else {
                        memo.put(cur, new int[] {str, idx});
                    }
                }
            }
            return res;
        }
    }
}


