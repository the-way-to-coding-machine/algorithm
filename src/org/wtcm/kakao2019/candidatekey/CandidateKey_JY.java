package org.wtcm.kakao2019.candidatekey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CandidateKey_JY {
    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"}
                , {"200", "apeach", "math", "2"}
                , {"300", "tube", "computer", "3"}
                , {"400", "con", "computer", "4"}
                , {"500", "muzi", "music", "3"}
                , {"600", "apeach", "music", "2"}
        };

        System.out.println(new Task().solution(relation));
    }

    private static class Task {
        int colNum;
        int rowNum;
        String[][] table;
        List<int[]> picked = new ArrayList<>();

        int solution(String[][] relation) {
            int answer = 0;
            table = relation;
            rowNum = relation.length;
            colNum = relation[0].length;

            List<int[]> allPairs = combination(colNum); // 가능한 모든 컬럼 조합 ( 1개부터 ~ 모든 컬럼 갯수)
            LinkedList<int[]> candidates = new LinkedList<>();
            for (int[] keys : allPairs) {
                if (hasShorter(candidates, keys)) continue;
                if (isCandidateKey(keys)) {
                    candidates.add(keys);
                }
            }

            return candidates.size();
        }

        List<int[]> combination(int size) {
            for (int toPick = 1; toPick <= size; toPick++) {
                int[] result = new int[toPick];
                pick(result, size, toPick, 0, 0);
            }
            return picked;
        }

        void pick(int[] resultArray, int total, int toPick, int num, int resultIdx) {
            if (toPick == 0) {
                picked.add(resultArray.clone());
                return;
            }
            if (num == total) return;
            resultArray[resultIdx] = num;

            pick(resultArray, total, toPick - 1, num + 1, resultIdx+1);
            pick(resultArray, total, toPick, num + 1, resultIdx);
        }

        boolean isCandidateKey(int[] pair) {
            StringBuilder join = new StringBuilder();
            HashMap<String, Integer> map = new HashMap<>();
            for (int row = 0; row < rowNum; row++) {
                for (int col : pair) join.append(table[row][col]);
                if (map.containsKey(join.toString())) {
                    return false;
                } else {
                    map.put(join.toString(), 1);
                }
                join = new StringBuilder();
            }
            return true;
        }

        boolean hasShorter(LinkedList<int[]> candidates, int[] cur) {
            for (int[] candidate : candidates) {
                if (candidate.length >= cur.length) break;
            }
            return false;
        }
    }
}
