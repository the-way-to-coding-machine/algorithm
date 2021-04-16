package org.wtcm.kakaocloud;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int itemsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int itemsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> items = new ArrayList<>();

        IntStream.range(0, itemsRows).forEach(i -> {
            try {
                items.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int orderBy = Integer.parseInt(bufferedReader.readLine().trim());

        int orderDirection = Integer.parseInt(bufferedReader.readLine().trim());

        int pageSize = Integer.parseInt(bufferedReader.readLine().trim());

        int pageNumber = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result.solution(items, orderBy, orderDirection, pageSize, pageNumber);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static class Result {
        public static List<String> solution(List<List<String>> items, int orderBy, int orderDirection, int pageSize, int pageNumber) {
            // Write your code here
            List<String> result = new ArrayList<>();

            Collections.sort(items, new Comparator<List<String>>() {
                @Override
                public int compare(List<String> o1, List<String> o2) {
                    int ret = 0;
                    if (orderBy == 0) {
                        if (o1.get(orderBy).compareTo(o2.get(orderBy)) < 0) {
                            ret = -1;
                        } else if (o1.get(orderBy).compareTo(o2.get(orderBy)) == 0) {
                            ret = 0;
                        } else ret = 1;
                    } else {
                        if (Integer.parseInt(o1.get(orderBy)) < Integer.parseInt(o2.get(orderBy))) {
                            ret = -1;
                        } else if (Integer.parseInt(o1.get(orderBy)) == Integer.parseInt(o2.get(orderBy))) {
                            ret = 0;
                        } else ret = 1;
                    }

                    if (orderDirection == 1) ret *= -1;
                    return ret;
                }
            });

            List<List<String>> cur = items.subList(pageSize*pageNumber, Math.min(items.size(), pageNumber*pageSize+pageSize));
            for (List<String> tran : cur)
                result.add(tran.get(0));

            return result;
        }
    }
}