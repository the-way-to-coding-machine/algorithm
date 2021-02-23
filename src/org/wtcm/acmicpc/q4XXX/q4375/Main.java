package org.wtcm.acmicpc.q4XXX.q4375;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        int n, one;
        while((input = br.readLine()) != null) {
            n = Integer.parseInt(input);
            one = 0;

            for (int i = 1; ; i++) {
                one = one * 10 + 1;
                one %= n;
                // 그냥 1씩 더 붙이는것보다 이렇게 연산을 한번 더 해서 수를 줄이는게 더 나은 이유는
                // 큰 숫자의 연산을 하는것보다 이게 더 효율적이기 때문이다.
                // 이 연산으로 one의 범위가 최대 n-1까지로 좁혀지게 된다.
                if (one % n == 0) {
                    bw.write(i + "\n");
                    bw.flush();
                    break;
                }
            }
        }
    }
}
