package org.wtcm.acmicpc.q10XXX.q10973;

import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static int n;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (!prevPerm()) {
            bw.write(-1+"\n");
        } else {
            for (int num : seq)
                bw.write(num + " ");
            bw.write("\n");
        }
        bw.close();
    }

    private static boolean prevPerm() {
        int prefix = n-1;
        while(prefix > 0 && seq[prefix] > seq[prefix-1]) prefix--;
        if (--prefix == -1) return false;

        for (int max = n-1; max > prefix ; max--) {
            if (seq[prefix] > seq[max]) {
                swap(seq, prefix, max);
                break;
            }
        }

        int start = prefix+1;
        int end = n-1;
        while(start < end)
            swap(seq, start++, end--);

        return true;
    }

    private static void swap(int[] seq, int a, int b) {
        int tmp = seq[a];
        seq[a] = seq[b];
        seq[b] = tmp;
    }

}
