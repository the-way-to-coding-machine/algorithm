package org.wtcm.practice;

public class SegmentTree {
    private int[] tree;
    private int[] originArr;
    private int arrSize;


    public SegmentTree(int[] arr) {
        originArr = arr;
        int treeSize = (1<<(int)(Math.ceil(Math.log10(originArr.length)/Math.log10(2))+1))+1;
        tree = new int[treeSize];
        arrSize = originArr.length;
        init(1,1,arrSize);
    }

    private int init(int current, int start, int end) {
        if (start == end)
            return tree[current] = originArr[start];

        int mid = (start+end) >> 1;
        return init(current*2, start, mid) + init(current*2+1, mid+1, end);
    }

    public void update(int srcIndex, int desValue) {
        int diff = desValue - originArr[srcIndex];
        originArr[srcIndex] = desValue;
        update(srcIndex, diff, 1, 1, arrSize);
    }

    private void update(int changedIndex, int diff, int current, int left, int right) {
        if (changedIndex > right || changedIndex < left)
            return;

        tree[current] += diff;

        if (left != right) {
            int mid = (left+right) >> 1;
            update(changedIndex, diff, current*2, left, mid);
            update(changedIndex, diff, current*2+1, mid+1, right);
        }
    }

    private int rangeSum(int current, int targetRangeStart, int targetRangeEnd, int left, int right){
        if (targetRangeStart > right || targetRangeEnd < left) return 0;

        else if(targetRangeStart <= left && right <= targetRangeEnd) return tree[current];

        int mid = (left+right) >> 1;
        return rangeSum(current*2, targetRangeStart, targetRangeEnd, left, mid)
                + rangeSum(current*2+1, targetRangeStart, targetRangeEnd, mid+1, right);
    }


}
