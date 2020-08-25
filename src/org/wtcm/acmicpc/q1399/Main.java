package org.wtcm.acmicpc.q1399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static List<Integer> distanceList = new ArrayList<>();
    static int[][][][] moveCache = new int[4][10][10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] k = new int[N];
        int[] m = new int[N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            k[i] = Integer.parseInt(line[0]);
            m[i] = Integer.parseInt(line[1]);
        }

        for (int i = 0; i < N; i++) {
            Position pos = new Position(0, 0);
            makeDigList(1, m[i]);
            int direction;
            int distance;
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
