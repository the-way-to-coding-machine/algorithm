package org.wtcm.acmicpc.q1XXX.q1786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_JY {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
////        // ABC ABCDAB ABCDABCDABDE
////        // ABCDABD
        String T = br.readLine();
        String P = br.readLine();
        int[] k = new int[P.length()];

        List<Integer> ans = new ArrayList<>();

        for (int upper = 1, lower = 0; upper < P.length(); upper++) {
            while(lower > 0 && P.charAt(upper) != P.charAt(lower))
                lower = k[lower-1];
            if (P.charAt(upper) == P.charAt(lower))
                k[upper] = ++lower;
        }

        for (int text = 0, pattern = 0; text < T.length(); text++) {
            while(pattern > 0 && T.charAt(text) != P.charAt(pattern))
                pattern = k[pattern-1];

            if (T.charAt(text) == P.charAt(pattern)) {
                if (pattern == P.length()-1) {
                    ans.add(text - P.length() + 2);
                    pattern = k[pattern];
                } else pattern++;
            }
        }

        System.out.println(ans.size());
        for (int pos : ans)
            System.out.print(pos+" ");
    }

    static void kmp() throws IOException {
        String T = br.readLine();
        String P = br.readLine();
        int[] K = getFailureFunction(P);

        List<Integer> ans = new ArrayList<>();

        int text = 0, pattern = 0;
        while (text < T.length() - P.length()) {
            while (pattern < P.length() && T.charAt(text + pattern) == P.charAt(pattern))
                pattern++;

            if (pattern == P.length())
                ans.add(text + 1);

            if (pattern > 0 && T.charAt(text + pattern) != P.charAt(pattern)) {
                text += (pattern - K[pattern - 1]);
                pattern = K[pattern - 1];
            } else {
                text++;
            }
        }

        System.out.println(ans.size());
        for (int pos : ans)
            System.out.print(pos + " ");
    }

    /*
        실패함수를 구하는것도 결국엔 앞에 나온 pattern이 뒤에 또 나오는지 찾는 과정이다.
        이는 text에서 pattern을 찾는것과 다르지 않다.
    * */
    static int[] getFailureFunction(String P) {
        int[] ret = new int[P.length()];

        for (int upper = 1, lower = 0; upper + lower < P.length(); upper++) {
            for (lower = 0; upper + lower < P.length(); lower++) {
                if (P.charAt(upper + lower) == P.charAt(lower)) {
                    ret[upper + lower] = lower + 1;
                } else {
                    if (lower > 0) {
                        upper += (lower - ret[lower - 1]);
                        lower = ret[lower - 1];
                    } else break;
                }
            }
        }
        return ret;
    }

    static void kmp2() throws IOException {
        String T = br.readLine();
        String P = br.readLine();
        int[] K = new int[P.length()];
        List<Integer> ans = new ArrayList<>();

        for (int upper = 1, lower = 0; upper < P.length(); upper++) { // upper가 suffix
            while(lower > 0 && P.charAt(upper) != P.charAt(lower)) // lower가 prefix
                lower = K[lower-1];
            if (P.charAt(upper) == P.charAt(lower))
                K[upper] = ++lower;
        }

        for (int text = 0, pattern = 0; text < T.length(); text++) {
            while(pattern > 0 && T.charAt(text) != P.charAt(pattern))
                pattern = K[pattern-1];

            if (T.charAt(text) == P.charAt(pattern)) {
                if (pattern == P.length()-1) {
                    ans.add(text - P.length() + 2);
                    pattern = K[pattern];
                } else {
                    pattern++;
                }
            }
        }

        System.out.println(ans.size());
        StringBuilder sb = new StringBuilder();
        for(int pos : ans) sb.append(pos).append(" ");
        System.out.println(sb.toString());
    }
}