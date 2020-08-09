package org.wtcm.leetcode.q940;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


// note. Collections.frequency()로 collection의 element 갯수를 세아릴 수 있다.
// todo. 이 문제(를 포함한 dp문제) 연습해서 완전히 이해하기..!!
public class DistinctSubsequences2_JY { // dp problem
    public int distinctSubseqII(String S) {
        int modulo = 1_000_000_007;

        char[] string = S.toCharArray();
        /* note. 이게 endwith dict.
            근데 이건 key로 끝나는 subset의 갯수를 저장하는거다. --> 어떻게 구하지..?ㅎㅎ
            그렇다면 답은 endwith dict의 모든 value를 더하는것!! ==> 모든 알파벳을 돌면서 그걸로 끝나는 subset의 갯수를 더하는거니깐.
        */
        HashMap<Character, Integer> dict = new HashMap<>();
        int[] dp = new int[string.length+1]; // note. dp가 subset 갯수인건 알겠는데 dp의 index가 뜻하는건..?
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

    public int aaa(String S) {
        int modulo = (int) 1e9+7;

        List<Character> string = S.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
//        List<Integer> end = new ArrayList<>(26);
        int[] end = new int[26];

        for (char ch : string) {
            end[ch - 'a'] = (IntStream.of(end).sum()+1) % modulo;
        }
        return IntStream.of(end).sum();
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