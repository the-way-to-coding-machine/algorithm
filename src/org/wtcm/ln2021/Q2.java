package org.wtcm.ln2021;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
//        int[] ball = {1, 2, 3, 4, 5, 6};
//        int[] order = {6, 2, 5, 1, 4, 3};

        int[] ball = {11, 2, 9, 13, 24};
        int[] order = {9, 2, 13, 24, 11};
        Arrays.stream(solution(ball, order)).forEach(System.out::println);
    }

    static int[] solution(int[] ball, int[] order) {
        Deque<Integer> balls = new ArrayDeque<>();
        int[] answer = new int[ball.length];
        HashMap<Integer, Integer> booked = new HashMap<>();
        int idx = 0;

        for (int b : ball)
            balls.add(b);


        for (int o : order) {
            while (booked.containsKey(balls.peekLast())) {
                answer[idx++] = balls.peekLast();
                booked.remove(balls.pollLast());
            }

            while (booked.containsKey(balls.peekFirst())) {
                answer[idx++] = balls.peekFirst();
                booked.remove(balls.pollFirst());
            }

            if (balls.peekFirst() == o) answer[idx++] = balls.pollFirst();
            else if (balls.peekLast() == o) answer[idx++] = balls.pollLast();
            else booked.put(o, 0);
        }
        return answer;
    }
}
