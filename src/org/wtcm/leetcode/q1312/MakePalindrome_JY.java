package org.wtcm.leetcode.q1312;

public class MakePalindrome_JY {
    //    // mbadm
//    // leetcode
//    /* note. it doesn't need to make real palindrome.
//        first, find the longest palindrome sub-sequence and make another palindrome with the rest characters.
//        the point is to find 'longest sub-sequence'..!!
//     */
//    public int minInsertions(String s) {
//        int cnt = 0;
//
//        if (s.length() % 2 == 0) {
//            s += "A";
//        }
//
//        char[] string = s.toCharArray();
//        int center = 0;
//
//        center = string.length / 2;
//        for (int first = 0; first < center; first++) {
//            if (string[first] != string[string.length - 1 - first])
//                ++cnt;
//        }
//        cnt *=2;
//        return s.endsWith("A") ? cnt-1 : cnt;
//    }

    /*  note.
            strategy : remove a character from the beginning.
                       then check the rest is palindrome.

    * */
    Integer[][] memo;
    public int minInsertions(String s) {
        memo = new Integer[s.length()][s.length()];
        char[] arr = s.toCharArray();
        return help(arr, 0, s.length() - 1);
    }

    int help(char[] arr, int l, int r) {
        if (l >= r)
            return 0;
        if (memo[l][r] != null)
            return memo[l][r];

        int count = 0;

        if (arr[l] == arr[r]) {
            count = help(arr, l + 1, r - 1);
        } else {
            count = Math.min(help(arr, l + 1, r), help(arr, l, r - 1)) + 1;
        }
        memo[l][r] = count;
        return count;
    }

    public int minInsertions1(String s) {
        final int n = s.length();
        int[] curr = new int[n];
        int[] pre = new int[n];

        for (int i = n - 1; i >= 0; i--) { // string의 끝글자부터 첫글자까지.
            for (int j = i; j < n; j++) {  // i번째 글자부터 오른쪽으로 진행
                if (i == j) {
                    curr[j] = 0;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j))
                    curr[j] = pre[j - 1];
                else curr[j] = 1 + Math.min(pre[j], curr[j - 1]);
            }
            int[] t = pre;
            pre = curr;
            curr = t;
        }
        return pre[n - 1];
    }

    int[][] cache;
    public int my(String s) {
        char[] string = s.toCharArray();
        int start = 0, end = s.length()-1;

        cache = new int[end+1][end+1];
        for (int i = 0; i <= end; i++)
            for (int j = 0; j <= end ; j++)
                cache[i][j] = -1;

        return cacheRemove(string, start, end);
    }

    public int remove(char[] string, int start, int end) {
        if (start >= end) return 0;
        if (string[start] == string[end])
            return remove(string, start+1, end-1);

        return Math.min(remove(string, start+1, end), remove(string, start, end-1))+1;
    }

    public int cacheRemove(char[] string, int start, int end) {
        if (start >= end) return 0;

        if (cache[start][end] != -1)
            return cache[start][end];

        if (string[start] == string[end])
            cache[start][end] = cacheRemove(string, start+1, end-1);
        else
            cache[start][end] = Math.min(cacheRemove(string, start+1, end), cacheRemove(string, start, end-1))+1;

        return cache[start][end];
    }
}
