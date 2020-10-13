package org.wtcm.acmicpc.q2XXX.q2248;

import java.io.*;
import java.util.StringTokenizer;

public class Main_JY {
    public static void main(String[] args) throws IOException {
        OutputWriter out = new OutputWriter(System.out);

        Task question = new Task();
        question.solution(out);
        out.close();
    }
}

class Task {
    int N, M;
    long K;
    long[][] cache;
    StringBuilder answer = new StringBuilder();

    void solution(OutputWriter out) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        cache = new long[N + 1][N + 1];
        cache[0][0] = 1;
        for (int n = 1; n <= N; n++) {
            for (int r = 0; r <= n; r++) { // 이건 그냥 전체 자릿수에서 1을 몇개 쓸거냐 하는 조합이다 nCr
                if (n == r || r == 0) cache[n][r] = 1;
                else cache[n][r] = cache[n - 1][r - 1] + cache[n - 1][r];
            }
        }

        findIthNumber(N, M, K);
        out.print(answer.toString());
    }

    private void findIthNumber(int n, int l, long k) {
        if (n == 0) return;
//        if (l == 0) { // note. 이게 없으니까 맞았다.. 근데 이유를 모르겠다
//            for (int i = 0; i < N; i++) answer.append("0");
//            return;
//        }

        long skip = 0;
        for (int i = 0; i <= l; i++) {
            skip += cache[n - 1][i]; // 맨 앞에 0을 넣고 만들 수 있는 경우의 수
        }
        if (skip >= k) { // skip >= k, skip이 더 크단건 뒷자리에서 l개의 1을 사용해서 k번째 숫자를 나타낼 수 있단거다.
            answer.append("0"); // 그러니깐 현재 자리에는 0을 넣는다.
            findIthNumber(n - 1, l, k);
        } else {
            answer.append("1"); // skip < k, skip이 더 작다는건 뒷자리에 l개의 0을 가지고 k번째 수를 못 만든다는거니깐 현재 자리까지 동원.
            findIthNumber(n - 1, l - 1, k - skip);
        }
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(int i) {
        writer.print(i);
    }

    public void print(long i) {
        writer.print(i);
    }

    public void print(Object... objects) {
        int len = objects.length;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
    }

    public void println() {
        writer.println();
    }

    public void close() {
        writer.close();
    }
}
