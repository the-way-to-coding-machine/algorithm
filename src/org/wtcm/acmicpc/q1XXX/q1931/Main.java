package org.wtcm.acmicpc.q1XXX.q1931;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> meets = new ArrayList<>();

        for (int i = 0; i < n; i++)
            meets.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());

        meets.sort((n1, n2) -> n1[1] - n2[1]);
        int cnt = 1;
        int prev = meets.get(0)[1];
        for (int cur = 1; cur < meets.size(); cur++) {
            if (prev <= meets.get(cur)[0]) {
                cnt++;
                prev = meets.get(cur)[1];
            }
        }

        bw.write(cnt+"\n");
        bw.close();
    }
}
