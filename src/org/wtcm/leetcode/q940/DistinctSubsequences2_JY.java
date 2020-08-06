package org.wtcm.leetcode.q940;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


// note. Collections.frequency()로 collection의 element 갯수를 세아릴 수 있다.
// todo. 이 문제(를 포함한 dp문제) 연습해서 완전히 이해하기..!!
public class DistinctSubsequences2_JY { // dp problem
    public int distinctSubseqII(String S) {
        int modulo = 1_000_000_007;

        char[] string = S.toCharArray();
        HashMap<Character, Integer> dict = new HashMap<>();
        int[] dp = new int[string.length+1];
        dp[0] = 1;

        for (int i = 0; i < string.length; i++) {
            dp[i+1] = dp[i] * 2 % modulo;
            if (dict.containsKey(string[i]))
                dp[i+1] -= dp[dict.get(string[i])];
            dp[i+1] %= modulo;
            dict.put(string[i], i);
        }

        dp[string.length]--;
        if (dp[string.length] < 0) dp[string.length] += modulo;
        return dp[string.length];
    }
}

/*
 public int distinctSubseqII(String S) {
 char[] string = S.toCharArray();
 Set<Character> set = new HashSet<>();
 int cnt = 0;

 for (char ch : string)
 set.add(ch);

 int length = set.toArray().length;

 for (int i = 0; i < (1 << length); i++) {
 for (int j = 0; j < length; j++) {
 if ((i & (1 << j)) > 0) {
 System.out.print(" "+set.toArray()[j]);
 }
 }
 System.out.println(""); ++cnt;
 }
 return cnt-1;
 }
 */