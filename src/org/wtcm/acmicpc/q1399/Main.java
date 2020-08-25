package org.wtcm.acmicpc.q1399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static List<Integer> distanceList = new ArrayList<>();
    static HashMap<Integer, List<Integer>> mMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] k = new int[N];
        int[] m = new int[N];
        int direction;
        int distance;

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            k[i] = Integer.parseInt(line[0]);
            m[i] = Integer.parseInt(line[1]);
        }

        for (int i = 0; i < N; i++) {
            Position pos = new Position(0, 0);
            makeDigList(1, m[i]);
            for (int cnt = 0; cnt < k[i]; cnt++) {
                direction = cnt % 4;
                distance = distanceList.get(cnt % distanceList.size());
                pos.move(direction, distance);
            }
            System.out.println(pos);
            distanceList = new ArrayList<>();
        }
    }

    static void makeDigList(int num, int m) {
        int event = num % 10 + 1;
        int start = sum(num);
        int tmp = start;

        do {
            distanceList.add(tmp);
        } while (((tmp = sum(tmp * m)) != start));
    }

    static int sum(int num) {
        int result = 0;

        do {
            while (num != 0) {
                result += num % 10;
                num /= 10;
            }
        } while (result > 9);

        return result;
    }
}

class Position {
    int x = 0;
    int y = 0;
    int[] xPos = {0, 1, 0, -1};
    int[] yPos = {1, 0, -1, 0};

    public Position() {
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int direction, int distance) {
        this.x += xPos[direction] * distance;
        this.y += yPos[direction] * distance;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

/*
* 1   : 1 -> 1
* 2   : 1 -> 2 -> 4 -> 8 -> 7 -> 5 -> 1
* 3   : 1 -> 3 -> 9 -> 9 -> 9 -> 9
* 4   : 1 -> 4 -> 7 -> 1
* 5   : 1 -> 5 -> 7 -> 8 -> 4 -> 2 -> 1
* 6   : 1 -> 6 -> 9 -> 9
* 7   : 1 -> 7 -> 4 -> 1
* 8   : 1 -> 8 -> 1
* 9   : 1 -> 9 -> 9
* 10  : 1 -> 1
* 11  : 1 -> 2 -> 4 -> 8 -> 7 -> 5 -> 1
* 12  : 1 ->
* 13  : 1 ->
* 14  : 1 ->
* .
* .
* 19  : 1 -> 1
* 20  : 1 -> 2 -> 4 -> 8 -> 7 -> 5 -> 1
* .
* .
* 29  : 1 -> 2 -> 4 -> 8 -> 7 -> 5 -> 1
* 30  : 1 -> 3 ->
* */