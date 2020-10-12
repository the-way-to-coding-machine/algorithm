package org.wtcm.kakao2019.pathfind;

public class PathFind_JY {
    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        Task question = new Task();
        int[][] result = question.solution(nodeinfo);

        for (int i = 0; i < result.length; i++) {
            System.out.print("["+result[i][0]);
            for (int j = 1; j < result[i].length; j++) {
                System.out.print(", "+result[i][j]);
            }
            System.out.println("]");
        }
    }

    private static class Task {
//      answer : [[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]
        public int[][] solution(int[][] nodeinfo) {
            int[][] answer = {};
            return answer;
        }
    }
}
