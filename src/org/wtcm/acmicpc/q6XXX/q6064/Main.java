package org.wtcm.acmicpc.q6XXX.q6064;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int t = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int N,M,X,Y;
            while(t-- > 0) {
                st = new StringTokenizer(br.readLine());
                M = Integer.parseInt(st.nextToken());
                N = Integer.parseInt(st.nextToken());
                X = Integer.parseInt(st.nextToken())-1;
                Y = Integer.parseInt(st.nextToken())-1;

                for (int year = 0;; year++) {
                    if (year % M == X && year % N == Y) {
                        bw.write((year+1)+"\n");
                        bw.flush();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
