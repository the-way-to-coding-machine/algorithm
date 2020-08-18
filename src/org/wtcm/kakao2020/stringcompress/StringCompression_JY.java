package org.wtcm.kakao2020.stringcompress;

public class StringCompression_JY {
    /* note.
            find the shortest expression of compressed string.
            the way how to compression is to split string by certain length of substring.
            and if there are some duplicate substring, they can express by number and duplicated substring.
            i.g) abababcdecde -- split by 2 --> 3abcdecde (cdecde can not compress by 2).
            then, find the shortest expression.
    * */
    int cnt = 1;
    String result;
    String tmp = "";

    public int solution(String s) { // aabbacccd
        result = s;

        for (int length = 1; length <= s.length() / 2; length++) {
            for (int start = 0; start < s.length(); ) {
                int end = Math.min(s.length(), start + length);
                String cur = s.substring(start, end);
                String compare;

                for (int second = end; second <= s.length(); second += length) {
                    compare = s.substring(second, Math.min(s.length(), second + length));
                    if (cur.equals(compare)) {
                        cnt++;
                    } else {
                        if (cnt > 1) tmp += String.valueOf(cnt);
                        tmp += cur;
                        cnt = 1;
                        start = second;
                        break;
                    }
                }
            }
            if (result.length() > tmp.length()) {
                result = tmp;
            }
            tmp = "";
        }
        return result.length();
    }
}
