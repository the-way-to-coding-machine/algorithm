package org.wtcm.acmicpc.q14XXX.q14890;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[input[0]*2][input[0]];
        l = input[1];
        StringTokenizer st;
        for (int i = 0; i < input[0]; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < input[0]; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < input[0]; i++)
            for (int j = 0; j < input[0]; j++)
                map[i+input[0]][j] = map[j][i];

        int road = 0;
        for (int i = 0; i < input[0]*2; i++) {
            int len = 1;
            boolean valid = true;
            for (int j = 0; j < input[0] - 1; j++) {
                if (map[i][j] == map[i][j+1]) len++;
                else if (map[i][j]+1 == map[i][j+1] && len >= l) len = 1; // 올라가는 길
                else if (map[i][j]-1 == map[i][j+1] && len >= 0) len = 1-l; // 내려가는 경우에는 앞으로 l개 칸을 사용해야 하므로 미리 l을 뺀다. (카운트를 1부터 시작하므로 1에서 뺌)
                else{
                    valid = false;
                    break;
                }
            }
            if (valid && len >= 0) road++;
        }

        bw.write(road + "\n");
        bw.close();
    }
}
