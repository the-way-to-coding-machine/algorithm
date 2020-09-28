package org.wtcm.acmicpc.q11XXX.q11657;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main_JY {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        Task question = new Task();
        question.solution(in, out);
        out.close();
    }
}


/* note. 벌써 여러번 overflow나 underflow때문에 여러번 실패했다. 이런거 계산도 연습 해야한다.
* */
class Task {
    int N, M;
    ArrayList<int[]>[] adjList;
    long[] distance;
    boolean cycle = false;

    public void solution(InputReader in, OutputWriter out) {
        int[] first = in.nextIntArray(2);
        N = first[0];
        M = first[1];

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int[] input = in.nextIntArray(3);
            adjList[input[0]].add(new int[]{input[1], input[2]});
        }

        distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0;
        for (int i = 1; i <= N; i++) { // n개의 vertex를 방문하는데 n개 이상의 edge를 지난다는건 cycle이 있다는 이야기.
            for (int cur = 1; cur <= N; cur++) {
                for (int[] next : adjList[cur]) {
                    if (distance[cur] != Long.MAX_VALUE && distance[next[0]] > distance[cur] + next[1]) {
                        distance[next[0]] = distance[cur] + next[1];
                        if (i == N) { // n번째인데 갱신이 됐다? --> 음수 사이클
                            cycle = true;
                            break;
                        }
                    }
                }
            }
        }

        if (cycle) out.print(-1);
        else {
            for (int i = 2; i <= N; i++) {
                out.print(distance[i] == Long.MAX_VALUE ? -1 : distance[i]); // 여기서 -1은 길이 없단뜻이다. 음의 사이클이 아니라.
                out.println();
            }
        }
    }
}

class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        } else {
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException var2) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
    }

    public boolean isSpaceChar(int c) {
        return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
    }

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public String next() {
        int c = this.read();
        while (isSpaceChar(c)) {
            c = this.read();
        }
        StringBuilder result = new StringBuilder();
        result.appendCodePoint(c);
        while (!isSpaceChar(c = this.read())) {
            result.appendCodePoint(c);
        }
        return result.toString();
    }

    public int nextInt() {
        int c = this.read();
        while (isSpaceChar(c)) {
            c = this.read();
        }
        byte sgn = 1;
        if (c == 45) {
            sgn = -1;
            c = this.read();
        }
        int res = 0;
        while (c >= 48 && c <= 57) {
            res *= 10;
            res += c - 48;
            c = this.read();
            if (isSpaceChar(c)) {
                return res * sgn;
            }
        }
        throw new InputMismatchException();
    }

    public String[] nextArray(int size) {
        String[] ret = new String[size];
        for (int i = 0; i < size; i++) {
            ret[i] = this.next();
        }
        return ret;
    }

    public int[] nextIntArray(int size) {
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = this.nextInt();
        }
        return ret;
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