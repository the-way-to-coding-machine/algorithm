package org.wtcm.acmicpc.q1XXX.q1238;

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
    int N,M,X;
    ArrayList<int[]>[] adjList;
    void solution(InputReader in, OutputWriter out) {
        N = in.nextInt();
        M = in.nextInt();
        X = in.nextInt();

        adjList = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            int[] input = in.nextIntArray(3);
            adjList[input[0]].add(new int[]{input[1], input[2]});
        }

        int max = Integer.MIN_VALUE;
        for (int stdNum = 1; stdNum <= N; stdNum++) {
            int length = dijkstra(stdNum, X) + dijkstra(X, stdNum);
            if (max < length) max = length;
        }
        out.print(max);
    }

    int dijkstra(int start, int dest) {
        int[] distance = new int[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1]-v2[1]);

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;
        pq.add(new int[]{start, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (distance[cur[0]] < cur[1]) continue; // note. visited를 쓰는 코드도 있고 안쓰는 코드도 있다.. 더 알아보자..
            if (cur[0] == dest) break;

            for (int[] next : adjList[cur[0]]) {
                int newPath = distance[cur[0]]+next[1];
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

// note. 새로운걸 또 가져왔다.. 뭐가빠를까..!
class FastIO {
    private static final int EOF = -1;

    private static final byte ASCII_n = 10;
    private static final byte ASCII_space = 32;
    private static final byte ASCII_minus = 45;
    private static final byte ASCII_0 = 48;
    private static final byte ASCII_9 = 57;

    private final DataInputStream din;
    private final DataOutputStream dout;

    private byte[] inbuffer;
    private int inbufferpointer, bytesread;
    private byte[] outbuffer;
    private int outbufferpointer;

    private byte[] bytebuffer;

    private FastIO() {
        this.din = new DataInputStream(System.in);
        this.dout = new DataOutputStream(System.out);

        this.inbuffer = new byte[65536];
        this.inbufferpointer = 0;
        this.bytesread = 0;
        this.outbuffer = new byte[20];
        this.outbufferpointer = 0;

        this.bytebuffer = new byte[20];
    }

    private byte read() {
        if (inbufferpointer == bytesread)
            fillbuffer();
        return bytesread == EOF ? EOF : inbuffer[inbufferpointer++];
    }

    private void fillbuffer() {
        try {
            bytesread = din.read(inbuffer, inbufferpointer = 0, inbuffer.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void write(byte b) {
        if (outbufferpointer == outbuffer.length)
            flushbuffer();
        outbuffer[outbufferpointer++] = b;
    }

    private void flushbuffer() {
        if (outbufferpointer != 0) {
            try {
                dout.write(outbuffer, 0, outbufferpointer);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            outbufferpointer = 0;
        }
    }

    private int nextInt() {
        byte b;
        while(isSpace(b = read()))
            ;
        boolean negative = false;
        if (b == '-') {
            negative = true;
            b = read();
        }
        int result = b - '0';
        while (isDigit(b = read()))
            result = result * 10 + b - '0';
        return negative ? -result : result;
    }

    private void println(int i) {
        if (i == 0) {
            write(ASCII_0);
        } else {
            if (i < 0) {
                write(ASCII_minus);
                i = -i;
            }
            int index = 0;
            while (i > 0) {
                bytebuffer[index++] = (byte) ((i % 10) + ASCII_0);
                i /= 10;
            }
            while (index-- > 0) {
                write(bytebuffer[index]);
            }
        }
        write(ASCII_n);
    }

    private boolean isSpace(byte b) {
        return b <= ASCII_space && b >= 0;
    }

    private boolean isDigit(byte b) {
        return b >= ASCII_0 && b <= ASCII_9;
    }
}