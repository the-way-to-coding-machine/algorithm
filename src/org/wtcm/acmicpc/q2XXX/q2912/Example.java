package org.wtcm.acmicpc.q2XXX.q2912;

import java.io.*;
import java.util.InputMismatchException;

public class Example {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        Task question = new Task();
        question.solution(in, out);

        out.close();
    }

    private static class Task {
        void solution(InputReader in, OutputWriter out) {

        }

        private static class SegmentTree {
            int[] arr;
            int arrLen;
            int[] tree;
            int treeLen;

            SegmentTree(int[] arr) {
                this.arr = arr;
                this.arrLen = arr.length;
                this.treeLen = 1 << ((int)Math.ceil(Math.log10(arrLen)/Math.log10(2))) + 1;
                this.tree = new int[treeLen];
                init(1, 1, arrLen);
            }

            int init(int current, int start, int end) {
                if (start == end) return tree[current] = arr[start];
                int mid = (start+end) >> 1;
                return init(current*2, start, mid) + init(current*2+1, mid+1, end);
            }


        }
    }

    private static class InputReader {
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

    private static class OutputWriter {
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
}

