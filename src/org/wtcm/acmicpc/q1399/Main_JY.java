package org.wtcm.acmicpc.q1399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main_JY {
    static List<Integer> distanceList = new ArrayList<>();
    static List<Position> posList = new ArrayList<>();
    static int[] xPos = {0, 1, 0, -1};
    static int[] yPos = {1, 0, -1, 0};

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
            int M = reduceM(m[i]);
            int startPoint = reducePos(k[i], M);
            int cycleLength = posList.size() - startPoint;
            int dest = (k[i] - startPoint) % cycleLength;
            System.out.println(posList.get(dest + startPoint));
            distanceList.clear();
            posList.clear();
        }
    }

    static int reduceM(int m) {
        return m % 9 == 0 ? 9 : m % 9;
    }

    static int reducePos(int k, int m) {
        int startPoint = 0;

        makeDigList(m);
        posList.add(new Position(0, 0));
        Position pos = new Position(0, 0);
        int idx = 0;
        int direction = 0;
        int distance = 0;
        int size = distanceList.size();

        for (int cnt = 0; cnt < k; cnt++) {
            if (m % 3 != 0) {
                idx = cnt % size;
            } else {
                if (cnt >= size) idx = size - 1;
                else idx = cnt % size;
            }
            direction = cnt % 4;
            distance = distanceList.get(idx);
            pos.x += xPos[direction] * distance;
            pos.y += yPos[direction] * distance;

            if ((startPoint = posList.indexOf(pos)) != -1) {
                break;
            }
            posList.add(new Position(pos.x, pos.y));
        }
        return Math.max(startPoint, 0);
    }

    static void makeDigList(int m) {
        int distance = 1;
        int gold = distance;

        while (!distanceList.contains(gold)) {
            distanceList.add(gold);
            distance *= m;
            gold = dig(distance);
        }
    }

    static int dig(int num) {
        int result = 0;
        while ((result = sum(num)) > 9) {
            num = result;
        }
        return result;
    }

    static int sum(int num) {
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public boolean equals(Object o) {
        Position tmp = (Position) o;
        return this.x == tmp.x && this.y == tmp.y;
    }
}

/*
 * 1   : 1 -> 1
 * 2   : 1 -> 2 -> 4 -> 8 -> 7 -> 5 -> 1
 * 3   : 1 -> 3 -> 9 -> 9 -> 9 -> 9 note
 * 4   : 1 -> 4 -> 7 -> 1
 * 5   : 1 -> 5 -> 7 -> 8 -> 4 -> 2 -> 1
 * 6   : 1 -> 6 -> 9 -> 9 note
 * 7   : 1 -> 7 -> 4 -> 1
 * 8   : 1 -> 8 -> 1
 * 9   : 1 -> 9 -> 9 note
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
 * .
 * .
 * 337 : 1 -> 4 ->
 * */


/*
 * 1 --> 4
 * 2 --> 12
 * 3 --> 12
 * 4 --> 12
 * 5 --> 28
 * 6 --> 12
 * 7 --> 12
 * 8 --> 4
 * 9 --> 4
 * */


/*
*
*
9
4 1
12 2
12 3
12 4
28 5
12 6
12 7
4 8
4 9
-----1-----
1 |  0 1
2 |  1 1
3 |  1 0
4 |  0 0
-----2-----
1 |  0 1
2 |  2 1
3 |  2 -3
4 |  -6 -3
5 |  -6 4
6 |  -1 4
7 |  -1 3
8 |  -3 3
9 |  -3 7
10 |  5 7
11 |  5 0
12 |  0 0
-----3-----
1 |  0 1
2 |  3 1
3 |  3 -8
4 |  -6 -8
5 |  -6 1
6 |  3 1
7 |  3 -8
8 |  -6 -8
9 |  -6 1
10 |  3 1
11 |  3 -8
12 |  -6 -8
-----4-----
1 |  0 1
2 |  4 1
3 |  4 -6
4 |  3 -6
5 |  3 -2
6 |  10 -2
7 |  10 -3
8 |  6 -3
9 |  6 4
10 |  7 4
11 |  7 0
12 |  0 0
-----5-----
1 |  0 1
2 |  5 1
3 |  5 -6
4 |  -3 -6
5 |  -3 -2
6 |  -1 -2
7 |  -1 -12
8 |  -2 -12
9 |  -2 -7
10 |  5 -7
11 |  5 -15
12 |  1 -15
13 |  1 -13
14 |  11 -13
15 |  11 -14
16 |  6 -14
17 |  6 -7
18 |  14 -7
19 |  14 -11
20 |  12 -11
21 |  12 -1
22 |  13 -1
23 |  13 -6
24 |  6 -6
25 |  6 2
26 |  10 2
27 |  10 0
28 |  0 0
-----6-----
1 |  0 1
2 |  6 1
3 |  6 -8
4 |  -3 -8
5 |  -3 1
6 |  6 1
7 |  6 -8
8 |  -3 -8
9 |  -3 1
10 |  6 1
11 |  6 -8
12 |  -3 -8
-----7-----
1 |  0 1
2 |  7 1
3 |  7 -3
4 |  6 -3
5 |  6 4
6 |  10 4
7 |  10 3
8 |  3 3
9 |  3 7
10 |  4 7
11 |  4 0
12 |  0 0
-----8-----
1 |  0 1
2 |  8 1
3 |  8 0
4 |  0 0
-----9-----
1 |  0 1
2 |  9 1
3 |  9 -8
4 |  0 -8
*

*
*
* */