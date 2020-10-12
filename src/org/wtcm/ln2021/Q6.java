package org.wtcm.ln2021;

import java.util.Arrays;

public class Q6 {
    public static void main(String[] args) {
        String[] companies = {"A fabdec 2", "B cebdfa 2", "C ecfadb 2"};
        String[] applicants = {"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"};

//        String[] companies = {"A abc 2", "B abc 1"};
//        String[] applicants = {"a AB 1", "b AB 1", "c AB 1"};

        Arrays.stream(solution(companies, applicants)).forEach(System.out::println);
    }

    static String[] solution(String[] companies, String[] applicants) {
        return null;
    }
}
