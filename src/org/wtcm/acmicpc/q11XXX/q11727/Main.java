package org.wtcm.acmicpc.q11XXX.q11727;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if (N == 1) bw.write(1+"\n");
        else if (N == 2) bw.write(3+"\n");
        else {
            int n = 0;
            int n_1 = 3;
            int n_2 = 1;
            for (int i = 3; i <= N; i++) {
                n = (n_1 + n_2*2)%10007;
                n_2 = n_1;
                n_1 = n;
            }
            bw.write(n+"\n");
        }
        bw.close();
    }
}
