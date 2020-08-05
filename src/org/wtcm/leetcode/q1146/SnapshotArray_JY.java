package org.wtcm.leetcode.q1146;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SnapshotArray_JY {
    public ArrayList<Integer> arr;
    public HashMap<Integer, List<Integer>> snapMap = new HashMap<>();
    public int snapped;

    public SnapshotArray_JY(int length) {
        this.arr = new ArrayList<>(length);
    }

    public void set(int index, int val) {
        arr.set(index,val);
    }

    public int snap() {
        snapMap.put(snapped, arr);
        return snapped++;
    }

    public int get(int index, int snap_id) {
        return snapMap.get(snap_id).get(index);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */