package org.wtcm.acmicpc.q5XXX.q5620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main_JY {
    static int N;
    static Point[] points;

    /* note. TreeSet 쓰는부분을 다시 공부해야함. 그거하고 추가한 sweep문제들 다시 풀어보자!!
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        points = new Point[N];
        for (int i = 0; i < N; i++) {
            int[] cur = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            points[i] = new Point(cur[0], cur[1]);
        }
        Arrays.sort(points, (p1, p2) -> p1.x - p2.x); // x 좌표로만 sorting.. 이거 불 안켜주지만 없으면 에러남..-.-
        TreeSet<Point> candidates = new TreeSet<>((p1, p2) -> p1.y == p2.y ? p1.x - p2.x : p1.y - p2.y); // 아래쪽부터, 왼쪽부터

        int closest = distance(points[0], points[1]);
        candidates.add(points[0]);
        candidates.add(points[1]);

        int start = 0;
        for (int i = 2; i < N; i++) {
            Point currentPoint = points[i];

            while (start < i) { // 여기서 가로로 솎아내고
                Point candidatePoint = points[start];
                int x = currentPoint.x - candidatePoint.x;
                if (x * x > closest) { // todo. x제곱과 거리를 비교하는게 무슨 의미가 있나..?
                    candidates.remove(candidatePoint);
                    start++;
                } else {
                    break;
                }
            }
            int d = (int) Math.sqrt(closest) + 1; // todo. 여기도 왜 거리에 sqrt를 해서 y에 +=를 하지..?
            Point lower = new Point(-100000, currentPoint.y - d);
            Point upper = new Point(100000, currentPoint.y + d);
            for (Point point : candidates.subSet(lower, upper)) { // 여기서 세로로 솎아낸다.
                int dis = distance(currentPoint, point);
                closest = Math.min(dis, closest);
            }
            candidates.add(currentPoint);
        }
        System.out.println(closest);
    }

    static int distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// note 내 효율성 2배인 AC... sweep 안썼는데 분석해보자..
//class B_5620 {
//    int N;
//    PriorityQueue<Node> distances = new PriorityQueue<>(new Comparator<Node>() {
//        @Override
//        public int compare(Node o1, Node o2) {
//            if(o1.x == o2.x) {
//                return o1.y - o2.y;
//            }
//            return o1.x-o2.x;
//        }
//    });
//
//    public B_5620() {
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            N = Integer.parseInt(br.readLine());
//            for (int i = 0; i < N; i++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                int x = Integer.parseInt(st.nextToken());
//                int y = Integer.parseInt(st.nextToken());
//                distances.add(new Node(x, y));
//            }
//            long answer = Long.MAX_VALUE;
//            Node[] nodes = new Node[4];
//            int index = 0;
//            nodes[index++] = distances.poll();
//            while (!distances.isEmpty()) {
//                nodes[index++ % 4] = distances.poll();
//                for (int i = 0; i < 4; i++) {
//                    for(int j = i+1;j<4;j++){
//                        answer = Math.min(answer, findDistance(nodes[i], nodes[j]));
//                    }
//                }
//            }
//            System.out.println(answer);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private int findDistance(Node first, Node second) {
//        if(first != null && second != null) {
//            int xx = first.x-second.x;
//            int yy = first.y-second.y;
//            return (xx*xx)+(yy*yy);
//        }
//        return Integer.MAX_VALUE;
//    }
//
//    class Node {
//        int x, y;
//
//        Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//}
