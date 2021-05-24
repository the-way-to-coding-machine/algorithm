package org.wtcm.acmicpc.q15XXX.q15662;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int t, k;
    static int[][] gears;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        gears = new int[t][8];
        for (int i = 0; i < t; i++)
            gears[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        k = Integer.parseInt(br.readLine());

        while(k-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int num = input[0]-1;
            int[] dirs = new int[t];
            dirs[num] = input[1];

            for (int i = num-1; i >= 0; i--) {
                if (gears[i][2] != gears[i+1][6])
                    dirs[i] = -dirs[i+1];
                else break;
            }

            for (int i = num+1; i < t; i++) {
                if (gears[i][6] != gears[i-1][2])
                    dirs[i] = -dirs[i-1];
                else break;
            }

            for (int i = 0; i < t; i++) {
                if (dirs[i] != 0) {
                    turn(i, dirs[i]);
                }
            }
        }

        int ans = 0;
        for (int[] gear : gears)
            if (gear[0] == 1) ans++;

        bw.write(ans+"\n");
        bw.close();
    }

    private static void turn(int num, int dir) {
        int[] ret = new int[8];

        if (dir == 1) {
            int tmp = gears[num][7];
            System.arraycopy(gears[num],0, ret, 1, 7);
            ret[0] = tmp;
        } else {
            int tmp = gears[num][0];
            System.arraycopy(gears[num], 1, ret, 0, 7);
            ret[7] = tmp;
        }

        gears[num] = ret;
    }
}