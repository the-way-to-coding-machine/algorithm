package org.wtcm.acmicpc.q1XXX.q1699;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) { // j가 최대일때만 선택하는게 아니라 각각의 j에 대해서 전부 검사해줘야한다.
                if (dp[i] > dp[i - j * j] + 1) {
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }

        bw.write(dp[n] + "\n");
        bw.close();
    }

    private static int split(int n) {
        // 이 코드가 왜 틀렸냐면 i가 무조건 제일 클때만 비교하기 때문에 12같은 경우 9를 먼저찾고 1을 3개 골라서 총 4개지만
        // 4를 먼저 선택하면 4를 3개 선택해서 더 작아질 수 있다.
        if (n <= 1) return 1;

        int i = 1;
        for (i = 1; i*i < n; i++);
        i--;

        return split(n-(i*i))+1;
    }
}
