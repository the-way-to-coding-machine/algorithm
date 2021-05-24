package org.wtcm.kintern2021;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q2 {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] ans = s.solution(places);
        for (int a : ans)
            System.out.print(a + " ");
    }

    private static class Solution {
        static boolean[][] checked;
        static int[] cMove = {1,0,-1,0};
        static int[] rMove = {0,1,0,-1};
        static String[] map;
        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];
            int idx = 0;

            for (String[] room : places) {
                checked = new boolean[5][5];
                map = room;
                int status = 1;
                outer :for (int row = 0; row < 5; row++) {
                    for (int col = 0; col < 5; col++) {
                        if (room[row].charAt(col) == 'P') {
                            if (checked[row][col]) continue;
                            if (!ok(row, col)) {
                                status = 0;
                                break outer;
                            }
                        }
                    }
                }

                answer[idx++] = status;
            }

            return answer;
        }

        private static boolean ok(int row, int col) {
            LinkedList<int[]> q = new LinkedList<>();
            q.add(new int[] {row, col});
            checked[row][col] = true;
            ArrayList<int[]> ppl = new ArrayList<>();
            ppl.add(new int[] {row, col});

            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nRow = cur[0] + rMove[dir];
                    int nCol = cur[1] + cMove[dir];
                    if (!isIn(nRow, nCol)) continue;
                    if (checked[nRow][nCol]) continue;
                    char c = map[nRow].charAt(nCol);

                    if (c == 'P') {
                        if (!distanced(ppl, nRow, nCol)) {
                            checked[nRow][nCol] = true;
                            return false;
                        } else {
                            checked[nRow][nCol] = true;
                            ppl.add(new int[] {nRow, nCol});
                            q.add(new int[] {nRow, nCol});
                        }
                    } else if (c == 'O') {
                        q.add(new int[] {nRow, nCol});
                        checked[nRow][nCol] = true;
                    }
                }
            }

            return true;
        }

        private static boolean distanced(ArrayList<int[]> ppl, int row, int col) {
            int dis = 0;
            for (int[] pos : ppl) {
                dis = Math.abs(pos[0] - row) + Math.abs(pos[1] - col);
                if (dis < 2) {
                    return false;
                } else if (dis == 2) {
                    if (pos[0] == row && map[row].charAt((pos[1] + col) / 2) != 'X')
                        return false;
                    if (pos[1] == col && map[(pos[0]+col)/2].charAt(col) != 'X')
                        return false;
                    if (row < pos[0]) {
                        if (col < pos[1]) {
                            if (map[row].charAt(col+1) != 'X' || map[pos[0]].charAt(pos[1]-1) != 'X')
                                return false;
                        } else {
                            if (map[row].charAt(col-1) != 'X' || map[pos[0]].charAt(pos[1]+1) != 'X')
                                return false;
                        }
                    } else {
                        if (col > pos[1]) {
                            if (map[row].charAt(col-1) != 'X' || map[pos[0]].charAt(pos[1]+1) != 'X')
                                return false;
                        } else {
                            if (map[row].charAt(col+1) != 'X' || map[pos[0]].charAt(pos[1]-1) != 'X')
                                return false;
                        }
                    }
                }
            }

            return true;
        }

        private static boolean isIn(int row, int col) {
            return (0 <= row && row< 5) && (0 <= col && col< 5);
        }
    }
}
