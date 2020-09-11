package org.wtcm.programmers.september;

/* note.
    Question.
        n개의 숫자가 든 배열이 있을때 두가지 규칙을 통해 1개가 남을때까지 숫자를 없앤다.
            1) 인접한 두개의 숫자를 골라 둘 중 하나를 없앤다.
            2) 고른 두 숫자 중에 더 작은 숫자를 없애는 것은 전체 과정 중에 최대 1번까지만 허용된다.
        이 때 주어진 배열에서 마지막까지 남을 수 있는 숫자들의 갯수는?
        e.g) a = [9, -1, -5]
            removeMax(9, -1) -> removeMax(-1, -5) ==> -5
            removeMin(-1, -5) -> removeMax(9, -1) ==> -1
            removeMax(-1, -5) -> removeMin(9, -5) ==> 9
            answer : 3개

*
* */
public class Q3 {
//        static int[] a = {9,-1,-5};
    static int[] a = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};

    public static void main(String[] args) {
        // idea. i번째 숫자보다 작은 숫자가 양쪽에 있으면 못살아남음.
        //       --> 나보다 작은 숫자가 한쪽에 몰려있으면 살 수있음..
        int lMin = Integer.MAX_VALUE;
        int rMin = Integer.MAX_VALUE;
        int answer = 0;

        int[] left = new int[a.length];
        int[] right = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int j =a.length-1-i;
            if (a[i] < lMin)
                lMin = a[i];
            left[i] = lMin;
            if (a[j] < rMin)
                rMin = a[j];
            right[j] = rMin;
        }

        for (int cur = 0; cur < a.length; cur++) {
            if ( left[cur] < a[cur] && right[cur] < a[cur]) continue;
            answer++;
        }
        System.out.println(answer);
    }
}
