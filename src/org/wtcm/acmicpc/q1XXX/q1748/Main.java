package org.wtcm.acmicpc.q1XXX.q1748;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int start = 1, len = 1; start <= num; start *= 10, len++) {
                int end = Math.min(start*10-1, num);
                ans += (long)(end-start+1)*len;
            }
            bw.write(ans + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
