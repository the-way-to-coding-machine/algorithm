package org.wtcm.programmers.september;

import java.util.HashSet;
/* note.
    Question.
        주어진 배열의 서로 다른 인덱스에 있는 두개의 숫자를 뽑아 만들 수 있는 모든 수를 오름차순으로 return하라.
*
* */
public class Q1 {
    static int[] numbers = {5, 0, 2, 7}; // test case
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {

        for (int i = 0; i < numbers.length - 1; i++)
            for (int j = i + 1; j < numbers.length; j++)
                set.add(numbers[i] + numbers[j]);

        set.stream().sorted().forEach(System.out::println);
    }
}
