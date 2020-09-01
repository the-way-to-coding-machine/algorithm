package org.wtcm.acmicpc.q1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_JY {
    static int T;
    static Position[] turrets;
    static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        turrets = new Position[2];

        // note. 어차피 두 원의 교점은 0,1,2,무한 중 하나다.
        for (int i = 0; i < T; i++) {
            int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            turrets[0] = new Position(values[0], values[1], values[2]);
            turrets[1] = new Position(values[3], values[4], values[5]);

            if (turrets[0].x == turrets[1].x && turrets[0].y == turrets[1].y) { // 동심원
                if (turrets[0].r != turrets[1].r)
                    answers.add(0);
                else
                    answers.add(-1);

            } else {
                int longer = Math.max(turrets[0].r, turrets[1].r);
                int shorter = Math.min(turrets[0].r, turrets[1].r);
                int add = (longer + shorter) * (longer + shorter);
                int sub = (longer - shorter) * (longer - shorter);
                int distance = turrets[0].distance(turrets[1]);

                if (sub > distance)
                    answers.add(0);
                else {
                    if (add < distance)
                        answers.add(0);
                    else if (add == distance || sub == distance)
                        answers.add(1);
                    else
                        answers.add(2);
                }
            }
        }
        answers.forEach(System.out::println);
    }
}

class Position {
    int x;
    int y;
    int r;

    public Position(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int distance(Position turret) {
        return (int) (Math.pow((turret.x - this.x), 2) + Math.pow((turret.y - this.y), 2));
    }

    @Override
    public boolean equals(Object obj) {
        Position cmp = ((Position) obj);
        return this.x == cmp.x
                && this.y == cmp.y
                && this.r == cmp.r;
    }

}