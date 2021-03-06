package org.wtcm.acmicpc.q11XXX.q11053;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main_JY {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        Task question = new Task();

        question.binSearch(in, out);
        out.close();
    }
}

class Task {
    int N;
    int[] arr;
    int[] lis;
    void solution(InputReader in, OutputWriter out) {
        N = in.nextInt();
        arr = in.nextIntArray(N);
        int[] dp = new int[N];

        for (int tail = 0; tail < N; tail++) {
            if (dp[tail] == 0) dp[tail] = 1;
            for (int front = 0; front < tail; front++) {
                if (arr[front] < arr[tail])
                    dp[tail] = Math.max(dp[front]+1, dp[tail]);
            }
        }
        Arrays.sort(dp);
        out.print(dp[dp.length-1]);
    }

    void binSearch(InputReader in, OutputWriter out) {
        N = in.nextInt();
        arr = in.nextIntArray(N);
        lis = new int[N+1];

        int idx = 0;
        lis[idx] = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (arr[i] > lis[idx]) {
                lis[++idx] = arr[i];
            } else {
                int position = lowerBound(0, idx, arr[i]);
                lis[position] = arr[i];
            }
        }
        out.print(idx);
    }

    int lowerBound(int begin, int end, int target) {
        int mid = 0;

        while(begin < end) {
            mid = (begin+end) >> 1;

            if (lis[mid] < target) {
                begin = mid+1;
            } else {
                end = mid;
            }
        }
        return end;
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