package org.wtcm.acmicpc.q11XXX.q11723;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static boolean[] involved = new boolean[21];
    static int n;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("all")) {
                Arrays.fill(involved, true);
            } else if (cmd.equals("empty")) {
                Arrays.fill(involved, false);
            } else {

                int val = Integer.parseInt(st.nextToken());

                if (cmd.equals("add")) {
                    involved[val] = true;
                } else if (cmd.equals("remove")) {
                    involved[val] = false;
                } else if (cmd.equals("check")) {
                    int result = involved[val] ? 1 : 0;
                    bw.write(result + "\n");
                } else {
                    involved[val] = !involved[val];
                }
            }
        }
        bw.close();
    }
}
