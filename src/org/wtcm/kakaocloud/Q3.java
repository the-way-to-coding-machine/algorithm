package org.wtcm.kakaocloud;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int start_timeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> start_time = IntStream.range(0, start_timeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int running_timeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> running_time = IntStream.range(0, running_timeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.solution(start_time, running_time);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static class Result {

        /*
         * Complete the 'solution' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY start_time
         *  2. INTEGER_ARRAY running_time
         */
        static int max = Integer.MIN_VALUE;
        static List<Integer> st = new ArrayList<>();
        static List<Integer> rt = new ArrayList<>();
        static int n;

        public static int solution(List<Integer> start_time, List<Integer> running_time) {
            // Write your code here
            n = start_time.size();
            List<int[]> merged = new ArrayList<>();
            for (int i = 0; i < start_time.size(); i++)
                merged.add(new int[] {start_time.get(i), running_time.get(i)});
            Collections.sort(merged, (t1, t2) -> t1[0] - t2[0]);
            for (int[] sr : merged) {
                st.add(sr[0]);
                rt.add(sr[1]);
            }
            go(0, 0);

            return max;
        }

        private static void go(int start, int cnt) {
            if (start == n-1) {
                max = Math.max(max, cnt+1);
                return;
            }

            for (int next = start+1; next < n; next++) {
                if(st.get(start) + rt.get(start) <= st.get(next))
                    go(next, cnt+1);

                go(next, cnt);
            }
        }

    }

}

