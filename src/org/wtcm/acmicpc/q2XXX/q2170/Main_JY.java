package org.wtcm.acmicpc.q2XXX.q2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_JY {
    static int N;
    static StringTokenizer st;
    static PriorityQueue<Line> lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        lines = new PriorityQueue<>((l1, l2) -> l1.start - l2.start);
        int start, end;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            lines.add(new Line(Math.min(start,end), Math.max(start,end)));
        }

        Line currentLine = lines.poll();
        start = currentLine.start;
        end = currentLine.end;
        int totalLength = 0;
        while(!lines.isEmpty()) {
            currentLine = lines.poll();

            if (currentLine.start > end) {
                totalLength += end-start;
                start = currentLine.start;;
                end = currentLine.end;
            } else {
                if (currentLine.end <= end) {
                    continue;
                } else {
                    end = currentLine.end;
                }
            }
        }
        totalLength += end - start;
        System.out.println(totalLength);
    }
}

class Line {
    int start;
    int end;

    public Line(int start, int end) {this.start = start; this.end = end;}
}