package org.wtcm.acmicpc.q1XXX.q1648;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;


public class Main {
    static int[][] memo;
    static int n, m, modulo = 9901;
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        n = in.nextInt();
        m = in.nextInt();
        memo = new int[n*m][1<<m];
        for (int i = 0; i < n * m; i++)
            Arrays.fill(memo[i], -1);

        int ans = go(0, 0);

        out.print(ans);
        out.close();
    }

    private static int go(int idx, int bits) {
        if (idx == n*m && bits == 0) return 1;
        if (idx >= n*m) return 0;

        if (memo[idx][bits] != -1) return memo[idx][bits];

        memo[idx][bits] = 0;
        if ((bits & 1) == 1) // preempted
            memo[idx][bits] = go(idx+1, bits >> 1);

        else {
            memo[idx][bits] = go(idx+1, (bits >> 1) | (1 << (m-1)));

            if ((idx % m) != (m-1) && (bits & 2) == 0)
                memo[idx][bits] += go(idx+2, bits >> 2);
        }

        return memo[idx][bits] %= modulo;
    }

    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        private int read() {
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

        private boolean isSpaceChar(int c) {
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

    private static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
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
}
