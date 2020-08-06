package org.wtcm.leetcode.q1385;

public class DistanceOfArray_JY {
    public int solution(int[] arr1, int[] arr2, int d) { // arr1의 원소 중 arr2의 모든 원소들과의 거리가 d 초과인 원소의 갯수
        // ex) arr1 = [4, 5, 8], arr2 = [10, 9, 1, 8], d = 2 일때, arr1의 8을 제외한 4, 5는 arr2의 모든 원소들과 거리가 2 이상이므로 답은 4, 5.
        int answer = arr1.length;

        for (int ar1 : arr1) {
            for (int ar2 : arr2) {
                if (((ar1 - ar2) <= d) && ((ar1 - ar2) >= -d)) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}
