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
    //    static int[] a = {9,-1,-5};
    static int[] a = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};

    public static void main(String[] args) {

    }
}
