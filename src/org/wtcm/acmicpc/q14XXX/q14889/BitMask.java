package org.wtcm.acmicpc.q14XXX.q14889;

import java.io.*;
import java.util.Arrays;

public class BitMask {
    static BufferedWriter bw;
    static BufferedReader br;
    static int n;
    static int[][] ppl;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        ppl = new int[n][n];
        for (int i = 0; i < n; i++)
            ppl[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        int ans = bitset();
        bw.write(ans + "\n");
        bw.close();
    }

    private static int bitset() {
        int min = Integer.MAX_VALUE;
        for (int subset = 0; subset < (1 << n); subset++) {
            int cnt = 0;
            for (int element = 0; element < n; element++) {
                if ((subset & (1 << element)) != 0) cnt++;
            }
            if (cnt == n / 2) {
                int team1 = 0, team2 = 0;
                for (int idx = 0; idx < n; idx++) {
                    int element = 1 << idx;
                    if ((subset & element) != 0)
                        team1 += element;
                    else
                        team2 += element;
                }
                min = Math.min(min, Math.abs(bitSum(team1) - bitSum(team2)));
            }
        }
        return min;
    }

    private static int bitSum(int set) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (((set & (1 << i)) != 0)) {
                for (int j = 0; j < n; j++) {
                    if ((set & (1 << j)) != 0) {
                        sum += ppl[i][j];
                    }
                }
            }
        }
        return sum;
    }
}
