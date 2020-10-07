package org.wtcm.acmicpc.q2XXX.q2407;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class Main_JY {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        Task question = new Task();
//        question.solution(in, out);
        question.convention(in, out);
        out.close();
    }
}

class Task {
    int N,M;
    void solution(InputReader in, OutputWriter out) {
        int[] input = in.nextIntArray(2);
        N = input[0];   M = input[1];

        BigInteger first = BigInteger.ONE;
        BigInteger second = BigInteger.ONE;

        // note. nCr --> n!/(n-r)!*r!
        for (int i = 0; i < M; i++) {
            first = first.multiply(new BigInteger(String.valueOf(N-i)));
            second = second.multiply(new BigInteger(String.valueOf(i+1)));
        }

        BigInteger ans = first.divide(second);
        out.print(ans);
    }

    void convention(InputReader in, OutputWriter out) {
        int[] input = in.nextIntArray(2);
        N = input[0];   M = input[1];

        BigInteger[][] cache = new BigInteger[N+1][N+1];
        cache[1][1] = BigInteger.ONE;
        cache[1][0] = BigInteger.ONE;
        for (int n = 2; n <= N; n++) {
            for (int r = 0; r <= n; r++) {
                if (n == r || r == 0) cache[n][r] = BigInteger.ONE;
                else cache[n][r] = cache[n-1][r-1].add(cache[n-1][r]);
            }
        }
        out.print(cache[N][M]);
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

    public void print(Object object) {
        writer.print(object);
    }

    public void print(long i) {
        writer.print(i);
    }

    public void println(Object... objects) {
        int len = objects.length;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
        writer.println();
    }

    public void close() {
        writer.close();
    }
}
