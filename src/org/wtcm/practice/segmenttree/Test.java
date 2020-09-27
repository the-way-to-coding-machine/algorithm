package org.wtcm.practice.segmenttree;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        SegmentTree stree = new SegmentTree(arr);
        stree.update(3, 9);
        stree.prefixSum(2,7);
    }
}
