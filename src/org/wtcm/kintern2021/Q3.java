package org.wtcm.kintern2021;

import java.util.Arrays;
import java.util.LinkedList;

public class Q3 {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n1 = 8, k1 = 2;
        String[] cmd1 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};

        int n2 = 8, k2 = 2;
        String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

        System.out.println(s.solution(n1, k1, cmd1));
    }

    private static class Solution {
        boolean[] list;
        public String solution(int n, int cursor, String[] cmds) {
            list = new boolean[n];
            Arrays.fill(list, true);

            LinkedList<Integer> removed = new LinkedList<>();
            int num = n-1;
            int distance = 0;
            for (String cmd : cmds) {
                switch (cmd.charAt(0)) {
                    case 'U':
                        distance = cmd.charAt(cmd.length()-1) - '0';
                        if (cursor - distance < 0) cursor = 0;
                        else cursor -= distance;
                    case 'D':
                        distance = cmd.charAt(cmd.length()-1) - '0';
                        if (cursor + distance > num) cursor = num;
                        else cursor += distance;
                        break;
                    case 'C':
                        list[cursor] = false;
                        removed.add(cursor);
                        if (cursor == num) cursor -= 1;
                        else cursor += 1;
                        num--;
                        break;
                    default:
                        if (!removed.isEmpty()) {
                            list[removed.pollLast()] = true;
                            num++;
                        }
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (boolean b : list)
                if (b) sb.append("O");
                else sb.append("X");

            return sb.toString();
        }
    }
}
