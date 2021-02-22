package org.wtcm.acmicpc.q2XXX.q2565;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<int[]> A = new ArrayList<>();

        for (int i = 0; i < n; i++)
            A.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());

        A.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] arr = new int[n+1];
        int idx = 1;
        for (int[] conn : A)
            arr[idx++] = conn[1];

        int[] dp = new int[n+1];
        int ans = 0;
        for (int last = 1; last <= n; last++) {
            dp[last] = 1;
            for (int cur = 1; cur < last; cur++) {
                // 아래의 비교는 dp[last]와 dp[cur]가 아니라 dp[cur]끼리 비교하는거라고 생각해야 한다.
                if (arr[cur] < arr[last])
                    dp[last] = Math.max(dp[cur]+1, dp[last]);
            }
            ans = Math.max(ans, dp[last]);
        }

        bw.write(n-ans+"\n");
        bw.close();
    }
}
