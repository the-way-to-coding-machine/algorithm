package org.wtcm.acmicpc.q2XXX.q2261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main_JY {
    static int N;
    static Pair[] points;
    static TreeSet<Pair> candidates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        points = new Pair[N];
        for (int i = 0; i < N; i++) {
            int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            points[i] = new Pair(values[0], values[1]);
        }
        Arrays.sort(points, (p1, p2) -> p1.x - p2.x);

        candidates = new TreeSet<>((p1, p2) -> p1.y == p2.y ? p1.x - p2.x : p1.y - p2.y);
        int closest = distance(points[0], points[1]);
        candidates.add(points[0]);
        candidates.add(points[1]);

        int start = 0;
        for (int i = 2; i < N; i++) {
            Pair currentPoint = points[i];

            while (start < i) {
                Pair candidatePoint = points[start];
                int x = currentPoint.x - candidatePoint.x;
                if (x * x > closest) {
                    candidates.remove(candidatePoint);
                    start++;
                } else {
                    break;
                }
            }
            int bound = (int) Math.sqrt(closest) + 1;
            // note. treeset 에서 Integer.MIN,MAX 값 처리를 못한다. 공부해볼것
            // note. 이 treeset 쓰는부분 제대로 이해하기!!
            Pair lower = new Pair(Integer.MIN_VALUE, currentPoint.y - bound);
            Pair upper = new Pair(Integer.MAX_VALUE, currentPoint.y + bound);
            for (Pair point : candidates.subSet(lower, upper)) {
                int distance = distance(currentPoint, point);
                closest = Math.min(distance, closest);
            }
            candidates.add(currentPoint);
        }
        System.out.println(closest);
    }

    static int distance(Pair p1, Pair p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}