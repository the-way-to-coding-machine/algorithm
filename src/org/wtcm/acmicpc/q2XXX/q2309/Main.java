package org.wtcm.acmicpc.q2XXX.q2309;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static int[] arr;
    static HashSet<Integer> fake = new HashSet<>();
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int over = 0;
            arr = new int[9];
            for (int i = 0; i < 9; i++) {
                int height = Integer.parseInt(br.readLine());
                arr[i] = height;
                over += height;
            }
            Arrays.sort(arr);
            over -= 100;
            pick(over);

            for (int i = 0; i < 9; i++)
                if (!fake.contains(arr[i]))
                    bw.write(arr[i]+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void pick(int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (set.contains(target - arr[i])) {
                fake.add(target);
                fake.add(arr[i]);
                break;
            }
            set.add(arr[i]);
        }
    }
}
