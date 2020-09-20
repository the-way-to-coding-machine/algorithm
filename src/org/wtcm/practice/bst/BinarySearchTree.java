package org.wtcm.practice.bst;

import java.util.Arrays;

public class BinarySearchTree {
    int[] arr;

    public BinarySearchTree(int[] arr) {
        this.arr = arr;
        Arrays.sort(this.arr);
    }

    boolean exists(int number) {
        int start = 0;
        int end = arr.length;
        int mid = end;

        while(start < end) {
            mid = (start+end) >> 1;
            if(arr[mid] < number) {
                start = mid+1;
            } else if (arr[mid] > number) {
                end = mid;
            } else {
                return true;
            }
        }
        return false;
    }

    int lowerBound(int number) {
        int start = 0;
        int end = arr.length;
        int mid = end;

        while(start < end) {
            mid = (start+end) >> 1;

            if(arr[mid] >= number) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return end;
    }

    int upperBound(int number) {
        int start = 0;
        int end = arr.length;
        int mid = end;

        while(start < end) {
            mid = (start+end) >> 1;

            if (arr[mid] <= number) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
