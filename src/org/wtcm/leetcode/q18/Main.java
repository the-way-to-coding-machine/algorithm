package org.wtcm.leetcode.q18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.concurrent.Future;

public class Main {
    static int target;
    static int k;
    static int[] nums;
    static int[][] memo;
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            target = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());
            nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(nums);

            int ans = pick();
            bw.write(ans);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int pick() {
        return 0;
    }
}
