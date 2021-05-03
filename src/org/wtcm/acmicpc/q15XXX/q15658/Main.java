package org.wtcm.acmicpc.q15XXX.q15658;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] nums;
    static int[] ops;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        pick(0, nums[0]);

        bw.write(max+"\n"+min);
        bw.close();
    }

    private static void pick(int idx, int res) {
        if (idx == n-1) {
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        if (ops[0] > 0) {
            ops[0]--;
            pick(idx+1, res+nums[idx+1]);
            ops[0]++;
        }

        if(ops[1] > 0) {
            ops[1]--;
            pick(idx+1, res-nums[idx+1]);
            ops[1]++;
        }

        if (ops[2] > 0) {
            ops[2]--;
            pick(idx+1, res*nums[idx+1]);
            ops[2]++;
        }

        if (ops[3] > 0) {
            ops[3]--;
            pick(idx+1, res/nums[idx+1]);
            ops[3]++;
        }
    }
}
