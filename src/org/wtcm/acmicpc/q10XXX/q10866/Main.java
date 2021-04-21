package org.wtcm.acmicpc.q10XXX.q10866;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        while(n-- > 0) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            int val = input.length > 1 ? Integer.parseInt(input[1]) : 0;

            if (cmd.equals("push_back")) {
                q.addLast(val);
            } else if (cmd.equals("push_front")) {
                q.addFirst(val);
            } else if (cmd.equals("front")) {
                Integer front = q.peekFirst();
                bw.write((front == null ? -1 : front) + "\n");
            } else if (cmd.equals("back")) {
                Integer back = q.peekLast();
                bw.write((back == null ? -1 : back) + "\n");
            } else if (cmd.equals("size")) {
                bw.write(q.size() + "\n");
            } else if (cmd.equals("empty")) {
                bw.write((q.size() == 0 ? 1 : 0) + "\n");
            } else if (cmd.equals("pop_back")) {
                Integer back = q.pollLast();
                bw.write((back == null ? -1 : back) + "\n");
            } else { // pop_front
                Integer front = q.pollFirst();
                bw.write((front == null ? -1 : front) + "\n");
            }
        }

        bw.close();
    }
}
