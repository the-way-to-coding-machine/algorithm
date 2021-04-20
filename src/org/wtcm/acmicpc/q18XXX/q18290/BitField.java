package org.wtcm.acmicpc.q18XXX.q18290;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class BitField {
    static int n, m, k, max = Integer.MIN_VALUE;
    static int[] map;
    static boolean[] visited;
    static ArrayList<Integer>[] checker;

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        map = new int[n * m];
        visited = new boolean[n * m];
        checker = new ArrayList[n * m];

        for (int i = 0; i < n * m; i++)
            checker[i] = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                map[row * m + col] = in.nextInt();
            }
        }

        init();
        go(0, k, 0);
        out.print(max);
        out.close();
    }

    private static void init() {
        for (int row = 0; row < n; row++) {
            for (int col = 1; col < m; col++) {
                checker[row * m + col].add(row * m + (col - 1));
            }
        }

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < m; col++) {
                checker[row * m + col].add((row - 1) * m + col);
            }
        }
    }

    private static void go(int idx, int left, int sum) {
        if (left == 0) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = idx; i < n * m; i++) {
            if (visited[i] || !valid(i)) continue;
            visited[i] = true;
            go(i, left - 1, sum + map[i]);
            visited[i] = false;
        }
    }

    private static boolean valid(int idx) {
        for (int num : checker[idx]) {
            if (visited[num])
                return false;
        }
        return true;
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