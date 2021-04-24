package org.wtcm.acmicpc.q1XXX.q1697;

import java.io.*;
import java.util.Arrays;

public class Main2 {
    static int[] memo = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ans = go(nk[0], nk[1]);
        bw.write(ans + "\n");
        bw.close();
    }

    private static int go(int src, int dest) {
        if (memo[dest] != 0) return memo[dest];
        if (dest <= src) return src-dest;
        else if (dest == 1) return 1;
        else if (dest % 2 == 0) {
            return memo[dest] = Math.min(dest-src, go(src, dest/2)+1);
        } else {
            return memo[dest] = Math.min(go(src, dest-1), go(src, dest+1))+1;
        }
    }
}
