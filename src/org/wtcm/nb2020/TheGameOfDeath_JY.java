package org.wtcm.nb2020;

public class TheGameOfDeath_JY {
    int[] parent;

    public int solution(int num, int[] target) { // num --> 마지막 숫자, target --> index의 사람이 지목한 사람.
        parent = new int[target.length];
        int cnt = 0;

        for (int i = 0; i < target.length; i++) {
            parent[i] = i;
        }

        int current = 0;
        while(++cnt < num) {
            if (findRoot(current) != findRoot(target[current])) // 이 if에 안걸리면 i ~ target[i] 는 한 cycle에 있다.
                union(current, target[current]);
            else {

            }
            current = target[current];
        }



        return current;
    }

    int findRoot(int node) {
        if (parent[node] == node)
            return node;

        return findRoot(parent[node]);
    }

    void union(int node1, int node2) {
        int root1 = findRoot(node1);
        int root2 = findRoot(node2);

        parent[root2] = root1;
    }
}
