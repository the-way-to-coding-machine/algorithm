package org.wtcm.acmicpc.q1XXX.q1507;

import java.io.*;
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

/*
* note.
*  처음에 문제 이해를 잘 못했다.
*  input으로 주어진 각 node간 weight들은 그 node들을 직접 잇는 경로가 아니다.(아닐수도 있다)
*  그냥 weight만 가지고 경로를 찾아내야한다.
* */

class Task {
    int N;
    int[][] distance;
    boolean[][] remove;
    void solution(InputReader in, OutputWriter out) {
        N = in.nextInt();
        distance = new int[N+1][N+1];
        remove = new boolean[N+1][N+1];

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                distance[i][j] = in.nextInt();

        if (!floydwarshall()) {
            out.print(-1);
            return;
        }

        int res = 0;
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                if (!remove[i][j])
                    res += distance[i][j];

        out.print(res>>1);
    }

    boolean floydwarshall() {
        for (int via = 1; via <= N; via++) {
            for (int start = 1; start <= N; start++) {
                for (int end = 1; end <= N; end++) {
                    // note. 이 조건문의 의미를 제대로 다시 이해하자. 지금은 잘 모른다...
                    if (start == end || start == via || end == via) continue;

                    else if(distance[start][end] > distance[start][via] + distance[via][end])
                        return false;

                    else if (distance[start][end] == distance[start][via] + distance[via][end]) {
                        remove[start][end] = true;
                        remove[end][start] = true;
                    }
                }
            }
        }
        return true;
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