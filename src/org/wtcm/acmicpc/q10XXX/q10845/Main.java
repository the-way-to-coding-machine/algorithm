package org.wtcm.acmicpc.q10XXX.q10845;

import java.io.*;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        int n = in.nextInt();
        queue q = new queue(n);
        while (n-- > 0) {
            switch (in.next().charAt(1)) {
                case 'u': // push
                    q.push(in.nextInt());
                    break;
                case 'r': // front
                    out.println(q.front());
                    break;
                case 'a': // back
                    out.println(q.back());
                    break;
                case 'i': // size
                    out.println(q.size());
                    break;
                case 'm': // empty
                    out.println(q.empty());
                    break;
                case 'o': // pop
                    out.println(q.pop());
                    break;
            }
        }

        out.close();
    }

    private static class queue {
        int[] arr;
        int head, tail;

        queue(int size) {
            arr = new int[size];
        }

        void push(int val) {
            arr[tail++] = val;
        }

        int front() {
            return head < tail ? arr[head] : -1;
        }

        int back() {
            return head < tail ? arr[tail-1] : -1;
        }

        int pop() {
            return head < tail ? arr[head++] : -1;
        }

        int empty() {
            return size() == 0 ? 1 : 0;
        }

        int size() {
            return tail - head;
        }
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

        public void println(Object... objects) {
            print(objects);
            println();
        }

        public void close() {
            writer.close();
        }
    }
}
