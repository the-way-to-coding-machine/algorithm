package org.wtcm.acmicpc.q2XXX.q2529;

import java.io.*;

public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static int n;
    static String comparators;
    static boolean[] used;
    static String min = "999999999", max = "-999999999";
    static StringBuilder sb;

    public static void main(String[] args) throws IOException { // todo : 다시 풀기
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        used = new boolean[10];
        comparators = br.readLine().replaceAll(" ", "");
        sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            used[i] = true;
            sb.append(i);
            go(i, 0);
            used[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }

        bw.write(max+"\n");
        bw.write(min+"\n");
        bw.close();
    }

    private static void go(int pNum, int cIdx) {
        if (sb.length() == comparators.length()+1) {
            String num = sb.toString();
            if (num.compareTo(min) < 0) {
                min = sb.toString();
            }
            if (num.compareTo(max) > 0) {
                max = sb.toString();
            }
            return;
        }

        if (comparators.charAt(cIdx) == '<') {
            for (int i = 0; i < 10; i++) {
                if (used[i]) continue;
                if (pNum < i) {
                    used[i] = true;
                    sb.append(i);
                    go(i, cIdx+1);
                    sb.deleteCharAt(sb.length()-1);
                    used[i] = false;
                }
            }

        } else if (comparators.charAt(cIdx) == '>') {
            for (int i = 0; i < 10; i++) {
                if (used[i]) continue;
                if (pNum > i) {
                    used[i] = true;
                    sb.append(i);
                    go(i, cIdx+1);
                    used[i] = false;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }
}
