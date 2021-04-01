package org.wtcm.acmicpc.q10XXX.q10972;

import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[] seq;
    static int[] ans;
    static int min;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        ans = new int[n];
        seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int prefix = getPostfix()-1;
        if (prefix == -1) {
            bw.write(prefix+"\n");
        } else {
            int tmp = seq[prefix];
            while(seq[min--] < seq[prefix]);
            seq[prefix] = seq[++min];
            seq[min] = tmp;
            Arrays.sort(seq, prefix+1, n);
            for (int num : seq)
                bw.write(num + " ");
        }
        bw.close();
    }

    private static int getPostfix() {
        int i = n-1;
        min = n-1;
        for (; i > 0; i--) {
            if (seq[min] > seq[i])
                min = i;
            if (seq[i] > seq[i - 1])
                break;
        }
        return i;
    }
}
