package org.wtcm.acmicpc.q11XXX.q11723;

import java.io.*;
import java.util.StringTokenizer;

public class BitMask {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int set = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("all")) {
                set = (1 << 20) - 1;
            } else if (cmd.equals("empty")) {
                set = 0;
            } else {
                int val = Integer.parseInt(st.nextToken());

                if (cmd.equals("add")) {
                    set |= (1 << (val-1));
                } else if (cmd.equals("remove")) {
                    set &= ~(1 << (val-1));
                } else if (cmd.equals("toggle")) {
                    set ^= (1 << (val-1));
                } else {
                    int result = (set & (1 << (val-1))) == 0 ? 0 : 1;
                    bw.write(result+"\n");
                }
            }
        }
        bw.close();
    }
}
