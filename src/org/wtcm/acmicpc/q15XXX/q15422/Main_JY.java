package org.wtcm.acmicpc.q15XXX.q15422;

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
    int N, M, F, S, T; // city, road, flight, departure, travel to
    ArrayList<int[]>[] adjList;

    void solution(InputReader in, OutputWriter out) {
        N = in.nextInt();
        M = in.nextInt();
        F = in.nextInt();
        S = in.nextInt();
        T = in.nextInt();

        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int[] input = in.nextIntArray(3);
            adjList[input[0]].add(new int[]{input[1], input[2]});
            adjList[input[1]].add(new int[]{input[0], input[2]});
        }
        int[] ret1 = dijkstra(S, T);
        int re1 = ret1[T];
        for (int i = 0; i < F; i++) {
            int[] input = in.nextIntArray(2);
            adjList[input[0]].add(new int[]{input[1], 0});
        }
        int[] ret2 = dijkstra(S, T);
        int re2 = ret2[T];

        out.print(Math.min(re1,re2));
    }

    int[] dijkstra(int start, int dest) {
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1,v2) -> v1[1]-v2[1]);

        pq.add(new int[]{start, 0});
        distance[start] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] > distance[cur[0]]) continue;
            if (cur[0] == dest) break;

            for (int[] next : adjList[cur[0]]) {
                int nextPath = next[1] + distance[cur[0]];
                if (distance[next[0]] > nextPath) {
                    distance[next[0]] = nextPath;
                    pq.add(new int[]{next[0], nextPath});
                }
            }
        }
        return distance;
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