package org.wtcm.acmicpc.q1XXX.q1248;

import java.io.*;

public class Practice {
    static BufferedWriter bw;
    static BufferedReader br;
    static int n;
    static int[][] s;
    static int[] ans;
    static boolean isEnd;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        ans = new int[n];

        int idx = 0;
        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                switch (input.charAt(idx++)) {
                    case '+':
                        s[i][j] = 1;
                        break;
                    case '-':
                        s[i][j] = -1;
                        break;
                    case '0':
                        s[i][j] = 0;
                        break;
                }
            }
        }

        pick(0);
        for (int num : ans)
            bw.write(num + " ");
        bw.close();
    }

    private static void pick(int idx) {
        if (idx == n) {
            isEnd = true;
            return;
        }

        if (s[idx][idx] == 0) {
            ans[idx] = 0;
            if (check(idx))
                pick(idx+1);

            if (isEnd) return;
        }

        for (int i = 1; i <= 10; i++) {
            ans[idx] = i * s[idx][idx];
            if (check(idx))
                pick(idx+1);
            if (isEnd) return;
        }
    }

    private static boolean check(int idx) {
        int sum = 0;

        for (int i = idx; i >= 0; i--) {
            sum += ans[i];
            if (s[i][idx] == 1) {
                if (sum <= 0) return false;
            } else if (s[i][idx] == -1) {
                if (sum >= 0) return false;
            } else {
                if (sum != 0) return false;
            }
        }

        return true;
    }
}
