package org.wtcm.acmicpc.q15XXX.q15650;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static BufferedWriter bw;
    static BufferedReader br;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> seq = new LinkedList<>();

        pick(1, 0, seq);
        bw.close();
    }

    private static void pick(int curPos, int pickedCnt, LinkedList<Integer> seq) throws IOException {
        if (pickedCnt >= M) {
            for (int num : seq)
                bw.write(num+" ");

            bw.write("\n");
            bw.flush();
            return;
        }

        if (curPos > N) return;

        seq.add(curPos);
        pick(curPos+1, pickedCnt+1, seq);
        seq.pollLast();

        pick(curPos+1, pickedCnt, seq);
    }
}
