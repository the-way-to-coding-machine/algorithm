package org.wtcm.acmicpc.q2XXX.q2583;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

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
    int N,M,K;
    int[][] map;
    boolean[][] visited;
    int[] rowMove = {0,1,0,-1};
    int[] colMove = {1,0,-1,0};
    void solution(InputReader in, OutputWriter out) {
        int[] fl = in.nextIntArray(3);
        N = fl[0];  M = fl[1];  K = fl[2];
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int k = 0; k < K; k++) {
            int[] coordinate = in.nextIntArray(4);
            for (int row = N-coordinate[3]; row < N-coordinate[1]; row++)
                for (int col = coordinate[0]; col < coordinate[2]; col++)
                    map[row][col] = 1;
        }

        List<Integer> answer = new ArrayList<>();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (!visited[row][col] && map[row][col] == 0)
                    answer.add(dfs(row, col));
            }
        }
        Collections.sort(answer);
        out.print(answer.size());
        out.println();
        for (int territory : answer) out.print(territory+" ");
    }

    int dfs(int row, int col) {
        if (map[row][col] == 1 || visited[row][col]) return 0;

        visited[row][col] = true;
        int cnt = 1;
        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row+rowMove[direction];
            int nextCol = col+colMove[direction];

            if (!isIn(nextRow, nextCol)) continue;
            if (visited[nextRow][nextCol]) continue;
            if (map[nextRow][nextCol] == 1) continue;

            cnt += dfs(nextRow, nextCol);
        }
        return cnt;
    }

    boolean isIn(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < M;
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
