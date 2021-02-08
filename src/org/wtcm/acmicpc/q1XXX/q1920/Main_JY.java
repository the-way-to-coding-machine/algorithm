package org.wtcm.acmicpc.q1XXX.q1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_JY {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] ns;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        ns = new int[N];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            ns[i] = Integer.parseInt(s1[i]);
        }

        M = Integer.parseInt(br.readLine());
        ans = new int[M];
        BinarySearchTree binarySearchTree = new BinarySearchTree(ns);
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            if (binarySearchTree.exists(Integer.parseInt(s2[i])))
                ans[i] = 1;
            else ans[i] = 0;
        }

        for (int val : ans)
            System.out.println(val);
    }
}

class BinarySearchTree {
    int[] arr;

    public BinarySearchTree(int[] arr) {
        this.arr = arr;
        Arrays.sort(this.arr);
    }

    public boolean exists(int number) {
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

    public int lowerBound(int number) {
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

    public int upperBound(int number) {
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

