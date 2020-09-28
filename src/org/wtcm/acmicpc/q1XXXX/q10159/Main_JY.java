package org.wtcm.acmicpc.q1XXXX.q10159;

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

class Task {
    int N,M;
    int[][] adjMatrix;
    void solution(InputReader in, OutputWriter out) {
        int[] first = in.nextIntArray(2);
        N = first[0];   M = first[1];
        adjMatrix = new int[N+1][N+1];
        for (int i = 0; i < N + 1; i++)
            for (int j = 0; j < N + 1; j++)
                if (i != j) adjMatrix[i][j] = 200001;

        for (int i = 0; i < M; i++) {
            int[] input = in.nextIntArray(2);
            adjMatrix[input[0]][input[1]] = 1;
        }
        // 모순되는게 없다 --> cycle이 없다.
        for (int via = 1; via <= N; via++) {
            for (int start = 1; start <= N; start++) {
                for (int end = 1; end <= N; end++) {
                    if (adjMatrix[start][end] > adjMatrix[start][via] + adjMatrix[via][end]) {
                        adjMatrix[start][end] = adjMatrix[start][via] + adjMatrix[via][end];
                    }
                }
            }
        }
        for (int from = 1; from <= N; from++) {
            int cnt = 0;
            for (int to = 1; to <= N; to++) {
                if (from == to) continue;
                if (adjMatrix[from][to] >= 200001 && adjMatrix[to][from] >= 200001)   cnt++;
            }
            out.print(cnt);
            out.println();
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