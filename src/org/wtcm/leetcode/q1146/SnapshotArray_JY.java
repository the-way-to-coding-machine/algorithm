package org.wtcm.leetcode.q1146;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnapshotArray_JY {
    public int[] arr;
    public List<Snap> snaps = new ArrayList<>();
    public Snap snap = new Snap();
    public int id;

    public SnapshotArray_JY(int length) {
        arr = new int[length];
    }

    public void set(int index, int val) {
        arr[index] = val;
        snap.add(index, val);
    }

    public int snap() {
        snaps.add(snap);
        snap = new Snap(snap.map);
        return id++;
    }

    public int get(int index, int snap_id) {
        return snaps.get(snap_id).get(index);
    }
}

class Snap {
    public HashMap<Integer, Integer> map = new HashMap<>();

    public Snap(HashMap<Integer, Integer> map) {
        this.map = (HashMap<Integer, Integer>) map.clone();
    }

    public Snap(){}

    public void add(int index, int value) {
        map.put(index, value);
    }

    public int get(int index) {
        if (!map.keySet().contains(index))
            return 0;

        return map.get(index);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */