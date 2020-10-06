package org.wtcm.acmicpc.q1XXX.q1797;

import java.io.*;
import java.util.ArrayList;
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
    int N;

    private static class Fan {
        int sex;
        int position;

        Fan(int[] info) {
            if (info[0] == 1) this.sex = info[0];
            else this.sex = -1;
            this.position = info[1];
        }
    }

    List<Fan> fans = new ArrayList<>();
    int[] sum;
    List<List<Integer>> same = new ArrayList<>();
    int MAX = 1000000;

    void solution(InputReader in, OutputWriter out) {
        N = in.nextInt();

        for (int i = 0; i < N; i++) fans.add(new Fan(in.nextIntArray(2)));
        fans.sort((e1, e2) -> e1.position - e2.position);

        if (N == 2) {
            out.print(fans.get(1).position - fans.get(0).position);
            return;
        }

        sum = new int[N];
        sum[0] = fans.get(0).sex;
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + fans.get(i).sex;
        }

        for (int i = 0; i <= MAX + N; i++) {
            same.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            same.get(sum[i] + MAX).add(i);
        }

        int longest=0;
        for (int i = 0; i < N+MAX; i++) {
            int tmp = 0;
            if (same.get(i).size() > 1) {
                int end = same.get(i).get(same.get(i).size()-1);
                int start = same.get(i).get(0)+1;
                tmp = fans.get(end).position-fans.get(start).position;
            }
            longest = Math.max(longest, tmp);
        }
        out.print(longest);
    }

    void solution2(InputReader in, OutputWriter out) {
        //        int start=0, end=1, longest=0;

//        while (end < fans.size() && start < end) {
//            if (fans.get(end).sex != fans.get(end-1).sex) {
//                if ((end-start) % 2 == 0) {
//                    int longer = Math.max(fans.get(end).position- fans.get(start+1).position, fans.get(end-1).position- fans.get(start).position);
//                    longest = Math.max(longest, longer);
//                } else {
//                    longest = Math.max(longest, fans.get(end).position- fans.get(start).position);
//                }
//
//                end++;
//            }
//            else {
//                start = end;    end++;
//            }
//        }
//        out.print(longest);
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
