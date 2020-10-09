package org.wtcm.programmers.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* note.
    Question.
        주어진 배열의 서로 다른 인덱스에 있는 두개의 숫자를 뽑아 만들 수 있는 모든 수를 오름차순으로 return하라.
*
* */
public class Q1 {
    private static class Task {
        int[] numbers = {5, 0, 2, 7}; // test case
        HashSet<Integer> set = new HashSet<>();

        int[] solution() {
            for (int i = 0; i < numbers.length - 1; i++)
                for (int j = i + 1; j < numbers.length; j++)
                    set.add(numbers[i] + numbers[j]);

            List<Integer> tmp = set.stream().sorted().collect(Collectors.toList());
            int[] answer = new int[tmp.size()];
            for (int idx = 0; idx < answer.length; idx++)
                answer[idx] = tmp.get(idx);

            return answer;
        }
    }

    public static void main(String[] args) {
        Arrays.stream(new Task().solution()).forEach(System.out::println);
    }
}

