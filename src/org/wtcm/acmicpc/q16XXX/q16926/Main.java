package org.wtcm.acmicpc.q16XXX.q16926;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int n, m, r;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        r = input[2];

        matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int shells = Math.min(m, n) / 2;
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        for (int shell = 0; shell < shells; shell++) {
            ArrayList<Integer> group = new ArrayList<>();
            for (int upper = shell; upper < m - shell - 1; upper++)
                group.add(matrix[shell][upper]);

            for (int right = shell; right < n - shell - 1; right++)
                group.add(matrix[right][m - 1 - shell]);

            for (int lower = m - 1 - shell; lower > shell; lower--)
                group.add(matrix[n - shell - 1][lower]);

            for (int left = n - shell - 1; left > shell; left--)
                group.add(matrix[left][shell]);

            groups.add(group);
        }

        int[][] ret = new int[n][m];
        for (int shell = 0; shell < shells; shell++) {
            ArrayList<Integer> group = groups.get(shell);
            int offset = r % group.size();

            for (int upper = shell; upper < m - shell - 1; upper++)
                ret[shell][upper] = group.get(offset++ % group.size());

            for (int right = shell; right < n - shell - 1; right++)
                ret[right][m - 1 - shell] = group.get(offset++ % group.size());

            for (int lower = m - 1 - shell; lower > shell; lower--)
                ret[n - shell - 1][lower] = group.get(offset++ % group.size());

            for (int left = n - shell - 1; left > shell; left--)
                ret[left][shell] = group.get(offset++ % group.size());
        }

        for(int[] row : ret) {
            for (int col : row) {
                bw.write(col+" ");
            }
            bw.write("\n");
        }

        bw.close();
    }
}
