package org.wtcm.acmicpc.q1XXX.q1248;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] s;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        ans = new int[n];

        String input = br.readLine();
        int idx = 0;
        s = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char ch = input.charAt(idx++);
                if (ch == '+') {
                    s[i][j] = 1;
                } else if (ch == '-') {
                    s[i][j] = -1;
                } else {
                    s[i][j] = 0;
                }
            }
        }

        pick(0);
        for (int num : ans) {
            bw.write(num + " ");
        }
        bw.close();
    }


    private static boolean pick(int idx) {
        if (idx == n)
            return true;

        if (s[idx][idx] == '0') {
            ans[idx] = 0;
            return check(idx) && pick(idx+1);

        }

        for (int num = 1; num <= 10; num++) {
            ans[idx] = s[idx][idx] * num;
            if (check(idx) && pick(idx+1)) return true;
        }
        return false;
    }

    private static boolean check(int idx) {
        int sum = 0;

        for (int i = idx; i >= 0; i--) {
            sum += ans[i];
            if (s[i][idx] == 0) {
                if (sum != 0) return false;
            } else if (s[i][idx] > 0) {
                if (sum <= 0) return false;
            } else {
                if (sum >= 0) return false;
            }
        }
        return true;
    }
}
