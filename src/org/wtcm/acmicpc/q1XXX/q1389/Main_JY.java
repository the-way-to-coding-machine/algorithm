package org.wtcm.acmicpc.q1XXX.q1389;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class Main_JY {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        Task question = new Task();
//        question.solution(in, out);
        question.floyd(in, out);
        out.close();
    }
}

class Task {
    int N, M;
    final int INF = 10000000;
    ArrayList<int[]>[] adjlist;

    void solution(InputReader in, OutputWriter out) {
        int[] first = in.nextIntArray(2);
        N = first[0];
        M = first[1];
        adjlist = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adjlist[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int[] input = in.nextIntArray(2);
            adjlist[input[0]].add(new int[]{input[1], 1});
            adjlist[input[1]].add(new int[]{input[0], 1});
        }

        int minUser = 0, minValue = Integer.MAX_VALUE;
        for (int user = 1; user < N; user++) {
            int currentValue = dijkstra(user);
            if (minValue > currentValue) {
                minUser = user;
                minValue = currentValue;
            }
        }
        out.print(minUser);
    }

    void floyd(InputReader in, OutputWriter out) {
        int[] first = in.nextIntArray(2);
        N = first[0];
        M = first[1];
        int[][] users = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++)
            for (int j = 0; j < N + 1; j++)
                if (i != j)
                    users[i][j] = INF;

        for (int i = 0; i < M; i++) {
            int[] input = in.nextIntArray(2);
            users[input[0]][input[1]] = 1;
            users[input[1]][input[0]] = 1;
        }

        for (int middle = 1; middle <= N; middle++)
            for (int start = 1; start <= N; start++)
                for (int end = 1; end <= N; end++)
                    users[start][end] = Math.min(users[start][end], users[start][middle] + users[middle][end]);

        int minUser = 0, minValue = Integer.MAX_VALUE;
        for (int user = 1; user <= N; user++) {
            int cur = Arrays.stream(users[user]).sum();
            if (minValue > cur) {
                minValue = cur;
                minUser = user;
            }
        }
        out.print(minUser);
    }


    int dijkstra(int start) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);

        pq.add(new int[]{start, 0});
        distance[start] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] > distance[cur[0]]) continue;

            for (int[] next : adjlist[cur[0]]) {
                int newLength = cur[1] + next[1];
                if (distance[next[0]] > newLength) {
                    distance[next[0]] = newLength;
                    pq.add(new int[]{next[0], newLength});
                }
            }
        }
        return Arrays.stream(distance).sum();
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