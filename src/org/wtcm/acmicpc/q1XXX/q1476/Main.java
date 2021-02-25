package org.wtcm.acmicpc.q1XXX.q1476;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int E = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int e = 1, s = 1, m = 1, year = 1;

            while(true) {
                if (e==E && s==S && m==M)
                    break;

                e = e % 15+1;
                s = s % 28+1;
                m = m % 19+1;
                year++;
            }

            bw.write(year+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
