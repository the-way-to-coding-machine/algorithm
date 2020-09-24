package org.wtcm.acmicpc.q2XXX.q2419;

import java.io.*;
import java.util.Arrays;
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
    int N, M;
    int[] candy;
    int[][][] dp;
    final int LEFT = 0, RIGHT = 1;

    void solution(InputReader in, OutputWriter out) {
        int[] first = in.nextIntArray(2);
        N = first[0];
        M = first[1];
        dp = new int[N + 1][N + 1][2];
        candy = new int[N + 1];

        int idx = 1;
        for (int pos : in.nextIntArray(N))
            candy[idx++] = pos;

        Arrays.sort(candy);

        idx = lowerBound(candy, 0, candy.length, 0);
        int max = Integer.MIN_VALUE;
        for (int basket = 0; basket <= N; basket++) {
            for (int i = 0; i <= N; i++) for (int j = 0; j <= N; j++) Arrays.fill(dp[i][j], -1);

            max = Math.max(max, M * basket - meltCandy(idx, idx, LEFT, basket));
        }
        out.print(max);
    }
    // note. 로직 이해는 했지만 다시 한번 보기.
    int meltCandy(int start, int end, int direction, int taken) {
        if (taken == 0) return 0;
        if (dp[start][end][direction] != -1) return dp[start][end][direction];

        int goLeft = Integer.MAX_VALUE, goRight = Integer.MAX_VALUE;
        int distance = 0;
        if (start > 0) { // 왼쪽으로 갈 수 있음
            distance = (direction == LEFT ? candy[start] - candy[start - 1] : candy[end] - candy[start - 1]);
            goLeft = meltCandy(start - 1, end, LEFT, taken - 1) + distance * taken;
        }

        if (end < N) { // 오른쪽으로 갈 수 있음
            distance = (direction == RIGHT ? candy[end + 1] - candy[end] : candy[end + 1] - candy[start]);
            goRight = meltCandy(start, end + 1, RIGHT, taken - 1) + distance * taken;

        }
        return dp[start][end][direction] = Math.min(goLeft, goRight);
    }

    int lowerBound(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) >> 1;

            if (arr[mid] < target) {
                start = mid + 1;
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