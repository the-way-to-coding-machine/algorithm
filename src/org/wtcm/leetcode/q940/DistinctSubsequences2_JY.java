package org.wtcm.leetcode.q940;

// note. Collections.frequency()로 collection의 element 갯수를 세아릴 수 있다.
// todo. 이 문제(를 포함한 dp문제) 연습해서 완전히 이해하기..!!
public class DistinctSubsequences2_JY { // dp problem

    int modulo = 1_000_000_007;
    // note. 이해는 완전히 되긴 됐는데, 좀 더 찬찬히 뜯어보기


    /* note.
        1) O(n) space 풀이
            dp[i] --> String의 i번째 글자까지 탐색했을 때의 subsequence 갯수.
            last[i] --> i == {String의 i번째 글자 - 'a'} 로 26글자의 알파벳 dictionary 구성.
                        last[i] 는 해당 알파벳이 처음 나온 위치
            dp[i] 는 dp[i-1] 에서 생성된 subsequence들의 뒤에 String의 i번째 글자가 append 되면서 만들어지므로
            dp[i] == 2*dp[i-1]. but, 중복되는 글자가 있을 수 있기 때문에 여기서 dp[last[i]] (i번째 글자까지로 만든 subsequence갯수)를 빼준다.
        2) O(1) space 풀이
            전반적으론 다 똑같고 dp배열 대신 prev와 cur을 쓴다. 한가지 다른점은 last[i]가 i번째 글자의 위치가 아니라 i번째 글자로 만든 subsequence갯수를 저장한다.
            --> 사실상 last가 O(n) 풀이의 dp나 마찬가지 아닌가? 하고 생각했는데 채점해보니 역시 별로 차이가 없다.
    * */
    public int distinctSubseqII(String S) {
        int[] dict = new int[26];
        char[] string = S.toCharArray();
        int prev = 1;
        int cur=0;

        for (int i = 0; i < string.length; i++) {
            int idx = string[i]-'a';
            cur = (2*prev) % modulo;
            cur -= dict[idx];
            cur = cur >= 0 ? cur % modulo : cur+modulo;
            dict[idx] = prev;
            prev = cur;
        }
        return --cur;
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