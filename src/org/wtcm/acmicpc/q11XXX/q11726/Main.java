package org.wtcm.acmicpc.q11XXX.q11726;

import java.io.*;

public class Main {
    static int n;
    static int modulo = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        int n_1 = 2;
        int n_2 = 1;
        int ans = 0;
        if (n == 1) bw.write(1+"\n");
        else if (n == 2) bw.write(2+"\n");
        else {
            for (int i = 3; i <= n; i++) {
                ans = (n_1 + n_2) % modulo;
                n_2 = n_1;
                n_1 = ans;
            }

            bw.write(ans + "\n");
        }
        bw.close();
    }
}
