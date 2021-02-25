package org.wtcm.acmicpc.q1XXX.q1107;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static String n;
    static HashSet<Integer> broken;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            n = br.readLine();
            int numN = Integer.parseInt(n);
            m = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++)
                broken.add(Integer.parseInt(st.nextToken()));

            int nearest, ans;
            if (Math.abs(numN-100) <= n.length()) {
                ans = Math.abs(numN-100);
            } else {
                nearest = remoteControl();
                ans = Math.abs(nearest-numN);
            }

            bw.write(ans+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int remoteControl() {
        StringBuilder sb = new StringBuilder();
        for (int seq = 0; seq < n.length(); seq++) {
            int num = n.charAt(seq) - '0';
            if (broken.contains(num)) {
                for (int dist = 1; dist+num < n.length(); dist++) {
                    if (num+dist < n.length() && !broken.contains(num+dist)) {

                    } else if (num-dist >= 0 && !broken.contains(num-dist)) {

                    } else {

                    }
                }

            } else {
                sb.append(n.charAt(seq));
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
