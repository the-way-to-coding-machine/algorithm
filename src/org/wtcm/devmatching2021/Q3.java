package org.wtcm.devmatching2021;

import java.util.HashMap;

public class Q3 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] e = {"john","mary","edward","sam","emily","jaimie","tod","young"};
        String[] r = {"-","-","mary","edward","mary","mary","jaimie","edward"};
        String[] s = {"young","john","tod","emily","mary"};
        int[] a = {12,4,2,5,10};

        sol.solution(e,r,s,a);
    }

    private static class Tree {
        String name;
        int profit;
        Tree parent;
        HashMap<String, Tree> children = new HashMap<>();

        Tree(String name) {
            this.name = name;
        }

        void addChild(String ref, String name) {
            if (ref.equals(this.name)) {
                Tree c = new Tree(name);
                c.parent = this;
                children.put(name, c);
                return;
            }

            for (Tree child : children.values()) {
                child.addChild(ref, name);
            }
        }

        Tree getChild(String name) {
            Tree t = children.get(name);

            if (t == null) {
                for (Tree child : children.values()) {
                    t = child.getChild(name);
                    if (t != null) break;
                }
            }
            return t;
        }

        void earn(int money) {
            if (this.name.equals("-")) {
                this.profit += money;
                return;
            }

            int val = money;
            int loyalty = val / 10;

            if (loyalty == 0)
                this.profit += val;
            else {
                if (this.parent != null)
                    this.parent.earn(loyalty);
                this.profit += (val - loyalty);
            }
        }
    }

    private static class Solution {
        static HashMap<String, Tree> people = new HashMap<>();
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer;
            Tree center = new Tree("-");

            for (int i = 0; i < enroll.length; i++)
                center.addChild(referral[i], enroll[i]);

            for (String name : enroll)
                people.put(name, center.getChild(name));

            int idx = 0;
            for (String name : seller)
                people.get(name).earn(100*amount[idx++]);

            answer = new int[enroll.length];
            for (int i = 0; i < answer.length; i++)
                answer[i] = people.get(enroll[i]).profit;

            return answer;
        }
    }
}
