package org.wtcm.acmicpc.q1XXX.q1309;

import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        long[][] memo = new long[n+1][3];
        int modulo = 9901;

        memo[1][0] = 1;
        memo[1][1] = 1;
        memo[1][2] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i][0] = (memo[i-1][0] + memo[i-1][1] + memo[i-1][2]) % modulo;
            memo[i][1] = (memo[i-1][0] + memo[i-1][2]) % modulo;
            memo[i][2] = (memo[i-1][0] + memo[i-1][1]) % modulo;
        }

        bw.write((memo[n][0]+memo[n][1]+memo[n][2])%modulo+"\n");
        bw.close();
    }
}
