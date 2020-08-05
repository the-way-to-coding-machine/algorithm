package org.wtcm.leetcode.q1146;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        SnapshotArray_JY question = new SnapshotArray_JY(3);
        question.set(0, 5);
        question.arr.stream().forEach(System.out::println);
        System.out.println(question.snap());
        question.set(0, 6);
        question.arr.stream().forEach(System.out::println);
        System.out.println(question.get(0, 0));
        question.arr.stream().forEach(System.out::println);
    }
}
