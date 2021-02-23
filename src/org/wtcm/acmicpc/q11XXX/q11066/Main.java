package org.wtcm.acmicpc.q11XXX.q11066;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n, ans;
        int[] files;
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            files = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ans = merge(n, files);
            bw.write(ans);
            bw.flush();
        }
    }

    private static int merge(int n, int[] files) {

    }
}
