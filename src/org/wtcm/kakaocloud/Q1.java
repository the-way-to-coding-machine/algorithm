package org.wtcm.kakaocloud;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int arrRows = Integer.parseInt(bufferedReader.readLine().trim());
        int arrColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, arrRows).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<String> result = Result.solution(arr);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static class Result {

        /*
         * Complete the 'solution' function below.
         *
         * The function is expected to return a STRING_ARRAY.
         * The function accepts 2D_STRING_ARRAY arr as parameter.
         */

        public static List<String> solution(List<List<String>> arr) {
            HashMap<String, Integer> map = new HashMap<>();
            List<String> result = new ArrayList<>();

            for (List<String> tran : arr) {
                String lender = tran.get(0);
                String borrower = tran.get(1);
                int value = Integer.parseInt(tran.get(2));
                if (!map.containsKey(lender))
                    map.put(lender, 0);
                if (!map.containsKey(borrower))
                    map.put(borrower, 0);

                map.put(lender, map.get(lender) - value);
                map.put(borrower, map.get(borrower) + value);
            }

            List<Map.Entry<String, Integer>> tmp = map.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e1.getValue() - e2.getValue())
                    .filter(x -> x.getValue() < 0)
                    .collect(Collectors.toList());

            if (tmp.size() == 0) result.add("None");
            else {
                int min = tmp.get(0).getValue();
                for (Map.Entry<String, Integer> e : tmp) {
                    if (e.getValue() != min) break;
                    result.add(e.getKey());
                }
                Collections.sort(result);
            }

            return result;
        }

    }
}
