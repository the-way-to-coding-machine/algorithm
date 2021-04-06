package org.wtcm.acmicpc.q14XXX.q14391;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] matrix;
    static byte[] bits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        bits = new byte[n*m];
        for (int i = 0; i < n; i++)
            matrix[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int ans = bitMask();

        bw.write(ans+"\n");
        bw.close();
    }

    private static int bitMask() {
        int max = Integer.MIN_VALUE;
        for (int subset = 0; subset < (1 << n * m); subset++) {
            int sum = 0;
            for (int row = 0; row < n; row++) {
                int cur = 0;
                for (int col = 0; col < m; col++) {
                    int idx = row*m + col;
                    if ((subset & (1<<idx)) != 0) { // 가로로 연결된 수를 더함
                        cur = cur*10 + matrix[row][col];
                    } else { // 끊기면 만든 수를 합산하고 새로운 수를 저장하기 위해 리셋.
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur; // 합산하는 부분이 끊길때 뿐이라 마지막까지 이어지는 경우가 누락되기 때문에 한번 더 더해줌.
            }

            for (int col = 0; col < m; col++) {
                int cur = 0;
                for (int row = 0; row < n; row++) {
                    int idx = row*m + col;
                    if ((subset & (1<<idx)) == 0) {
                        cur = cur*10 + matrix[row][col];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
