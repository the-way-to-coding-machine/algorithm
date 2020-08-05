package org.wtcm.leetcode.q1146;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        SnapshotArray_JY question = new SnapshotArray_JY(1);
        question.set(0, 15);
        Arrays.stream(question.arr).forEach(e -> System.out.print(e+" "));
        System.out.println("");

        System.out.println(question.snap());
        System.out.println(question.snap());
        System.out.println(question.snap());

        System.out.println(question.get(0,2));
        Arrays.stream(question.arr).forEach(e -> System.out.print(e+" "));
        System.out.println("");

        System.out.println(question.snap());
        System.out.println(question.snap());
        System.out.println(question.get(0, 0));
        Arrays.stream(question.arr).forEach(e -> System.out.print(e+" "));
        System.out.println("");
    }
}
