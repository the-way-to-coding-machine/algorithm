package org.wtcm.acmicpc.q2042;

import java.io.*;
import java.util.InputMismatchException;

public class Main_JY {

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        Task question = new Task();
        question.solution(in, out);
        out.close();
    }
}

class Task {
    int N, M, K;
    long[] arr, tree;

    public void solution(InputReader in, OutputWriter out) {
        N = in.nextInt();
        M = in.nextInt();
        K = in.nextInt();

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = in.nextInt();

        int treeHeight = (int) Math.ceil(log(2, N));
        int treeSize = 1 << (treeHeight + 1);
        tree = new long[treeSize + 1];

        makeSegmentTree(1, 1, N);

        for (int i = 0; i < M + K; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            if (a == 1) { // update
                long diff = c - arr[b];
                arr[b] = c;
                update(b, diff, 1, 1, N);
            } else { // prefix sum
                out.print(prefixSum(1, b, c, 1, N));
                if (i < M+K)
                    out.println();
            }
        }
    }

    long makeSegmentTree(int current, int start, int end) {
        if (start == end)
            return tree[current] = arr[start];

        int mid = (start + end) >> 1;
        return tree[current] = makeSegmentTree(current * 2, start, mid) + makeSegmentTree(current * 2 + 1, mid + 1, end);
    }

    long prefixSum(int current, int start, int end, int left, int right) { // [left, right] -> tree의 range. [start, end] -> 구하고자 하는 구간.
        if (start > right || end < left)
            return 0;

        else if (start <= left && right <= end)
            return tree[current];

        int mid = (left + right) >> 1;
        return prefixSum(current * 2, start, end, left, mid)
                + prefixSum(current * 2 + 1, start, end, mid+1, right);

    }

    void update(int changedIndex, long diff, int current, int left, int right) {
        if (changedIndex < left || changedIndex > right) // 바뀐 노드가 범위 밖이면 리턴
            return;

        tree[current] += diff; // 바뀐 노드를 포함하는 노드들은 모두 증감분을 더해준다.

        if (left != right) {
            int mid = (left + right) >> 1;
            update(changedIndex, diff, current * 2, left, mid);
            update(changedIndex, diff, current * 2 + 1, mid + 1, right);
        }
    }
    double log(int base, int num) {
        return Math.log10(num) / Math.log10(base);
    }
}

    // note. 헐... input output만 바꿔줬는데 elapse가 절반으로 줄었다... (760ms --> 312ms)
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