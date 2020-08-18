package org.wtcm.leetcode.q940;

import java.util.*;


// note. Collections.frequency()로 collection의 element 갯수를 세아릴 수 있다.
// todo. 이 문제(를 포함한 dp문제) 연습해서 완전히 이해하기..!!
public class DistinctSubsequences2_JY { // dp problem
    int modulo = 1_000_000_007;

    public int distinctSubseqII(String S) {
        char[] string = S.toCharArray();
        /* note. 이게 endwith dict.
            근데 이건 key로 끝나는 subset의 갯수를 저장하는거다. --> 어떻게 구하지..?ㅎㅎ
            그렇다면 답은 endwith dict의 모든 value를 더하는것!! ==> 모든 알파벳을 돌면서 그걸로 끝나는 subset의 갯수를 더하는거니깐.
        */
        HashMap<Character, Integer> dict = new HashMap<>();
        int[] dp = new int[string.length + 1]; // note. dp가 subset 갯수인건 알겠는데 dp의 index가 뜻하는건..?
        dp[0] = 1;

        for (int i = 0; i < string.length; i++) {
            dp[i + 1] = dp[i] * 2 % modulo;
            if (dict.containsKey(string[i]))
                dp[i + 1] -= dp[dict.get(string[i])];
            dp[i + 1] %= modulo;
            dict.put(string[i], i);
        }
        dp[string.length]--;
        if (dp[string.length] < 0) dp[string.length] += modulo;
        return dp[string.length];
    }

    int[] cache;
    char[] s;
    Set<String> subset = new HashSet<>();

    public int main(String S) {
        s = S.toCharArray();
//        bruteSelect("", 0);

        cache = new int[S.length() + 1];
        for (int i = 0; i <= S.length(); i++)
            cache[i] = -1;

//        return subset.size()-1;
        int answer = cacheSelect("", 0) - 1;
        return answer;
    }

    public void bruteSelect(String substring, int index) {
        if (index >= s.length) {
            subset.add(substring);
            return;
        }
        if (index <= s.length - 1)
            bruteSelect(substring + s[index], index + 1);

        bruteSelect(substring, index + 1);
    }

    /*  note.
            이 문제는 은호 방식으로 안될 것 같다.. --> 가 아니라 여기서 아예 set 의 size를 반환해주면 될듯..!!
            --> 도 안된다.. 역시 cache를 index만 고려할게 아니라 알파벳까지 고려하자..!
    * */
    public int cacheSelect(String substring, int index) {
        if (index >= s.length) {
            if (subset.contains(substring)) return 0;
            subset.add(substring);
            return 1;
        }

        if (cache[index] != -1) return cache[index];

        int yes=0, no=0;
        if (index <= s.length - 1)
            yes = cacheSelect(substring + s[index], index + 1);

        no = cacheSelect(substring, index+1);

        return cache[index] = yes+no;
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