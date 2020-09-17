package org.wtcm.acmicpc.q1504;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class Main_JY {
    static int N,E,V1,V2;
    static ArrayList<int[]>[] adjList;
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        N = in.nextInt();
        E = in.nextInt();
        adjList = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int[] input = in.nextIntArray(3);
            adjList[input[0]].add(new int[]{input[1], input[2]});
            adjList[input[1]].add(new int[]{input[0], input[2]});
        }
        V1 = in.nextInt();
        V2 = in.nextInt();


        int first=0, second=0;
        int sv1 = dijkstra(1,V1);
        int v12 = dijkstra(V1,V2);
        int v2n = dijkstra(V2,N);
        if (sv1 == Integer.MAX_VALUE | v12 == Integer.MAX_VALUE | v2n == Integer.MAX_VALUE) first = -1;
        else first = sv1+v12+v2n;

        int sv2 = dijkstra(1,V2);
        int v21 = dijkstra(V2,V1);
        int v1n = dijkstra(V1,N);
        if (sv2 == Integer.MAX_VALUE | v21 == Integer.MAX_VALUE | v1n == Integer.MAX_VALUE) second = -1;
        else second = sv2+v21+v1n;

        if (first < 0 && second < 0) {
            out.print(-1);
        } else if (first < 0 && second > 0) {
            out.print(second);
        } else if (first > 0 && second < 0) {
            out.print(first);
        } else {
            out.print(Math.min(first,second));
        }
        out.close();
    }

    static int dijkstra(int start, int dest) {
        int[] distance = new int[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1,v2) -> v1[1]-v2[1]);
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;
        pq.add(new int[]{start, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] > distance[cur[0]]) continue;
            if (cur[0] == dest) break;

            for (int[] next : adjList[cur[0]]) {
                int newPath = next[1] + distance[cur[0]];
                if (distance[next[0]] > newPath) {
                    distance[next[0]] = newPath;
                    pq.add(new int[]{next[0], newPath});
                }
            }
        }
        return distance[dest];
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
