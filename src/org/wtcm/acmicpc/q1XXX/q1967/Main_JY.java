package org.wtcm.acmicpc.q1XXX.q1967;

import java.io.*;
import java.util.*;

public class Main_JY {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        Task question = new Task();
        question.solution(in, out);
        out.close();
    }

    private static class Task {
        int N;
        ArrayList<int[]>[] tree;
        PriorityQueue<int[]> pq;
        void solution(InputReader in, OutputWriter out) {
            N = in.nextInt();
            tree = new ArrayList[N+1];
            for (int i = 0; i <= N; i++) tree[i] = new ArrayList<>();

            for (int i = 0; i < N-1; i++) {
                int[] input = in.nextIntArray(3);
                int from = input[0];
                int to = input[1];
                int weight = -input[2];

                tree[from].add(new int[] {to, weight});
                tree[to].add(new int[] {from, weight});
            }
            pq = new PriorityQueue<>((v1, v2) -> v1[1] - v2[1]);
            int[] endNode = bfs(1);
            pq.clear();
            out.print(bfs(endNode[0])[1]);
        }

        private int[] bfs(int start) {
            int[] distance = new int[N+1];
            Arrays.fill(distance, Integer.MIN_VALUE);
            int longestLength = 0;
            int longestNode = 0;

            distance[start] = 0;
            pq.add(new int[] {start, 0});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();

                if (cur[1] > distance[cur[0]]) continue;

                for (int[] next : tree[cur[0]]) {
                    int newLength = next[1] + distance[cur[0]];
                    if (distance[next[0]] < newLength) {
                        distance[next[0]] = newLength;
                        pq.add(new int[] {next[0], newLength});
                        if (newLength < longestLength) {
                            longestLength = newLength;
                            longestNode = next[0];
                        }
                    }
                }
            }
            return new int[] {longestNode, -longestLength};
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