package org.wtcm.acmicpc.q1XXX.q1753;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class Main_JY {
    public static void main(String[] args) {
        Task question = new Task();
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        question.solution(in, out);
        out.close();
    }
}

class Task {
    void solution(InputReader in, OutputWriter out) {
        int V,E, start;

        V = in.nextInt();
        E = in.nextInt();
        start = in.nextInt();
        int[] distance = new int[V+1];
        ArrayList<int[]>[] adjList = new ArrayList[V+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1]-v2[1]);

        for (int i = 0; i < V + 1; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int[] line = in.nextIntArray(3);
            adjList[line[0]].add(new int[]{line[1], line[2]});
        }
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (distance[cur[0]] < cur[1])  continue; // note. 이부분.

            for (int nxt = 0; nxt < adjList[cur[0]].size(); nxt++) { // 현재 노드에 연결된 다음 노드들.
                int[] next = adjList[cur[0]].get(nxt).clone();
                next[1] += distance[cur[0]];
                if(distance[next[0]] > next[1]) {
                    distance[next[0]] = next[1];
                    pq.add(next); // note. 이부분을 제대로 다시 이해해보자.
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                out.print("INF");
            else out.print(distance[i]);
            out.println();
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