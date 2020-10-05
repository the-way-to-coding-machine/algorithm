package org.wtcm.acmicpc.q2XXX.q2206;

import java.io.*;
import java.util.*;

class Main_JY {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        Task question = new Task();
        question.solution(in, out);
        out.close();
    }
}

class Task {
    int cols, rows;
    int[][] map;
    int[][][] visit;
    int[] xPos = {1, 0, -1, 0};
    int[] yPos = {0, 1, 0, -1};

    void solution(InputReader in, OutputWriter out) {
        int[] first = in.nextIntArray(2);
        rows = first[0];
        cols = first[1];
        map = new int[rows][cols];
        visit = new int[rows][cols][2];

        for (int row = 0; row < rows; row++)
            map[row] = Arrays.stream(in.next().split("")).mapToInt(Integer::parseInt).toArray();

        out.print(bfs());
    }

    int bfs() {
        ArrayDeque<int[]> Q = new ArrayDeque<>();

        Q.add(new int[]{0, 0, 1});
        visit[0][0][1] = 1;

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();

            if (cur[0] == rows - 1 && cur[1] == cols - 1) {
                return visit[cur[0]][cur[1]][cur[2]];
            }

            for (int direction = 0; direction < 4; direction++) {
                int[] next = {cur[0] + yPos[direction], cur[1] + xPos[direction], cur[2]};

                if (!isIn(next)) continue;
                if (map[next[0]][next[1]] == 1 && cur[2] == 1) { // 벽일때 뚫을수도 있을때.
                    visit[next[0]][next[1]][next[2]-1] = visit[cur[0]][cur[1]][cur[2]] + 1;
                    Q.add(new int[]{next[0], next[1], next[2] - 1});
                } else { // 그냥 길이거나, 벽인데 뚫을 수 없을때 --> 피함.
                    if (map[next[0]][next[1]] == 1) continue;
                    if (visit[next[0]][next[1]][next[2]] != 0) continue;
                    visit[next[0]][next[1]][next[2]] = visit[cur[0]][cur[1]][cur[2]] + 1;
                    Q.add(new int[] {next[0], next[1], next[2]});
                }
            }
        }
        return -1;
    }

    int bfsOrigin() {
        ArrayDeque<int[]> Q = new ArrayDeque<>();
        int[][] distance = new int[rows][cols];
        for (int i = 0; i < rows; i++) Arrays.fill(distance[i], -1);

        Q.add(new int[]{0, 0, 1});
        distance[0][0] = 1;
        visit[0][0][1] = 1;

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();

            if (cur[0] == rows - 1 && cur[1] == cols - 1) break;

            if (cur[2] > 0) { // break available
                for (int direction = 0; direction < 4; direction++) {
                    int[] next = {cur[0] + yPos[direction], cur[1] + xPos[direction], cur[2]};
                    if (!isIn(next) || visit[next[0]][next[1]][next[2]] == 1) continue;

                    if (map[next[0]][next[1]] == 1) {
                        Q.add(new int[]{next[0], next[1], next[2] - 1});
                        visit[next[0]][next[1]][next[2] - 1] = 1;
                        distance[next[0]][next[1]] = distance[next[0]][next[1]] == -1 ? distance[cur[0]][cur[1]]+1 : distance[next[0]][next[1]];
                    }
                }
            } else { // break unavailable
                for (int direction = 0; direction < 4; direction++) {
                    int[] next = {cur[0] + yPos[direction], cur[1] + xPos[direction], cur[2]};
                    if (!isIn(next)) continue;
                    if (map[next[0]][next[1]] == 1 || visit[next[0]][next[1]][next[2]] == 1) continue;
                    Q.add(next);
                    visit[next[0]][next[1]][next[2]] = 1;
                    distance[next[0]][next[1]] = distance[next[0]][next[1]] == -1 ? distance[cur[0]][cur[1]]+1 : distance[next[0]][next[1]];
                }
            }
        }
        return distance[rows-1][cols-1];
    }

    boolean isIn(int[] pos) {
        return 0 <= pos[0] && pos[0] < rows && 0 <= pos[1] && pos[1] < cols;
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