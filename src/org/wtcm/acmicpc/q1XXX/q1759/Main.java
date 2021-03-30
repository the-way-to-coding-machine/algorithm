package org.wtcm.acmicpc.q1XXX.q1759;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] chars;
    static int l, c;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        chars = br.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(chars);
        sb = new StringBuilder();
        pick(0, 0, 0, 0);
    }

//    private static void pick(int idx, int vowel, int cons, int cnt) throws IOException {
//        if (cnt == l) {
//            if (vowel >= 1 && cons >= 2) {
//                bw.write(sb.toString() + "\n");
//                bw.flush();
//            }
//            return;
//        }
//
//        if (idx >= c) return;
//
//        sb.append(chars[idx]);
//        if (isVowel(chars[idx]))
//            pick(idx + 1,vowel+1, cons, cnt + 1);
//        else
//            pick(idx+1, vowel, cons+1, cnt+1);
//        sb.deleteCharAt(sb.length() - 1);
//
//        pick(idx+1, vowel, cons, cnt);
//    }
//
    private static void pick(int start, int vowel, int cons, int cnt) throws IOException {
        if (cnt == l && (vowel >= 1 && cons >= 2)) {
            bw.write(sb.toString() + "\n");
            bw.flush();
            return;
        }

        for (int idx = start; idx < chars.length; idx++) {
            char ch = chars[idx];
            sb.append(ch);

            if (isVowel(ch))
                pick(idx + 1, vowel + 1, cons, cnt + 1);
            else
                pick(idx + 1, vowel, cons + 1, cnt + 1);

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
