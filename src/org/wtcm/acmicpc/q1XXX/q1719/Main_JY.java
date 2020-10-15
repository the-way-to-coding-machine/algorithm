package org.wtcm.acmicpc.q1XXX.q1719;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class Main_JY {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        Task question = new Task();
        question.solution(in, out);
        out.close();
    }
}

class Task {
    int N, M;
    ArrayList<int[]>[] map;
    PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1] - v2[1]);
    void solution(InputReader in, OutputWriter out) {
        int[] firstLine = in.nextIntArray(2);
        N = firstLine[0];   M = firstLine[1];
        map = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) map[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int[] input = in.nextIntArray(3);
            map[input[0]].add(new int[] {input[1], input[2]});
            map[input[1]].add(new int[] {input[0], input[2]});
        }

        for (int node = 1; node <= N; node++) {
            int[] firstTouch = dijkstra(node);
            for (int i = 1; i < firstTouch.length; i++) {
                if (i == node) out.print("- ");
                else out.print(firstTouch[i]+" ");
            }
            out.println();
            pq.clear();
        }
    }
    int[] distance, parent, path;
    int[] dijkstra(int start) {
        distance = new int[N+1];
        parent = new int[N+1];

        Arrays.fill(distance, 1000000001);
        distance[start] = 0;
        pq.add(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] > distance[cur[0]]) continue;

            for (int[] next : map[cur[0]]) {
                int newLength = distance[cur[0]] + next[1];
                if (distance[next[0]] > newLength) {
                    distance[next[0]] = newLength;
                    pq.add(new int[] {next[0], newLength});
                    parent[next[0]] = cur[0];
                }
            }
        }
        path = new int[N+1];
        for (int node = 1; node <= N; node++) {
            if (node == start) path[node] = 0;
            else {
                int cur = node;
                int prev = parent[cur];
                while (prev != start) {
                    cur = prev;
                    prev = parent[cur];
                }
                path[node] = cur;
            }
        }
        return path;
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
