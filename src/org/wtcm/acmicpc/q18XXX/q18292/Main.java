package org.wtcm.acmicpc.q18XXX.q18292;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {
    static int n,m,k;
    static int[][] map;
    static int[][] score;
    static int[][][] memo;
    static boolean[] preempted;
    static int[] bitCount;
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        // TODO : 포기... 도저히 못하겠음...
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        map = new int[n][m];
        score = new int[n][1<<m];
        memo = new int[n][k][1<<m]; // i번째 row, k개 고른 상태에서 bit field가 b 일때 max값.
        preempted = new boolean[1<<m]; // 각 칸의 왼쪽, 위쪽 칸이 체크 되어있음.
        bitCount = new int[1<<m];

        for (int bits = 0; bits < (1 << m); bits++)
            bitCount[bits] = Integer.bitCount(bits);
        
        for (int row = 0; row < n; row++) {
            for (int bits = 0; bits < (1 << m); bits++) {
                for (int col = 0; col < m; col++) {
                    if ((bits & (1<<col)) != 0)
                        score[row][bits] += map[row][col];
                }
            }
        }
        
        Arrays.fill(memo[0][0], 0);
        for (int i = 1; i < n; i++)
            for (int j = 1; j < k; j++)
                Arrays.fill(memo[i][j], -1);

        for (int i = 0; i < n; i++)
            map[i] = in.nextIntArray(m);

        for (int bits = 0; bits < 1 << m; bits++) {
            for (int col = 1; col < m; col++) {
                if ((bits & (1<<col)) == 0 && (bits&(1<<(col-1))) == 0)
                    preempted[bits] = true;
            }
        }

        for (int row = 0; row < n; row++) {
            for (int bits = 0; bits < (1 << m); bits++) {
                if (preempted[bits]) continue;
                for (int i = 0; i < 1; i++) {
                    
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 1 << m; i++)
            max = Math.max(max, memo[n][k][i]);

        out.print(max);
        out.close();
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
