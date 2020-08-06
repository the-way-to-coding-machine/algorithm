package org.wtcm.leetcode.q1104;

public class Runner {
    public static void main(String[] args) {
        PathInZigzagLabelledBinaryTree_JY question = new PathInZigzagLabelledBinaryTree_JY();
        int label = 14;
//        int label = 26;

        question.pathInZigZagTree(label).forEach(System.out::println);
    }
}
