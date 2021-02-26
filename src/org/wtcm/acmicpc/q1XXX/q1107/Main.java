package org.wtcm.acmicpc.q1XXX.q1107;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static int n;
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String input = br.readLine();
            n = Integer.parseInt(input);
            m = Integer.parseInt(br.readLine());

            if(m>0) { // m이 0일때 마지막줄 입력이 없는걸 생각못해서 엄청 해멨다...ㅠㅠㅠ
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < m; i++)
                    broken[Integer.parseInt(st.nextToken())] = true;
            }

            int ans = Math.abs(n - 100);
            if (ans > input.length()) {
                for (int i = 0; i < 1000000; i++) { // 이 1000000을 찾는것도 이 문제의 중요한 키 포인트다.
                    int near = findNearestNumber(i);
                    if (near != -1)
                        ans = Math.min(ans, Math.abs(n-i)+near);
                }
            }

            bw.write(ans + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findNearestNumber(int num) {
        int cnt = 0;
        if (num == 0)
            if (broken[num]) return -1;
            else return 1;

        while (num > 0) {
            if (broken[num % 10]) {
                return -1;
                //뒷자리부터 부셔졌냐?
            } else {
                //안부셔졌으면 버튼을 누르고 자릿수를 옮긴다.
                cnt++;
                num /= 10;
            }
        }
        return cnt;
    }
}
