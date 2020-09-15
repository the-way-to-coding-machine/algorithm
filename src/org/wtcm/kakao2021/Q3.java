package org.wtcm.kakao2021;

import java.util.Arrays;

public class Q3 {
    // note. 오잉.. 일단 테케 맞추는건 어렵지 않다.. 효율성은 안돌려봐서 모르겠네..
    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150"
                , "python frontend senior chicken 210"
                , "python frontend senior chicken 150"
                , "cpp backend senior pizza 260"
                , "java backend junior chicken 80"
                , "python backend senior chicken 50"
        };
        String[] query = {
                "java and backend and junior and pizza 100"
                , "python and frontend and senior and chicken 200"
                , "cpp and - and senior and pizza 250"
                , "- and backend and senior and - 150"
                , "- and - and - and chicken 100"
                , "- and - and - and - 150"};

        Arrays.stream(solution(info, query)).forEach(System.out::println);
    }

    static int[] solution(String[] info, String[] query) {
        Applicant[] people = new Applicant[info.length];
        int[] answer = new int[query.length];
        int idx = 0;
        for (String person : info)
            people[idx++] = new Applicant(person.split(" "));

        Applicants db = new Applicants(people);

        idx = 0;
        for (String q : query)
            answer[idx++] = db.search(q);

        return answer;
    }
}

class Applicants {
    Applicant[] people;

    public Applicants(Applicant[] people) {
        this.people = people;
    }

    public int search(String query) {
        String[] q = query.replaceAll("and", "").replaceAll("\\s{2,}", " ").split(" ");
        int matched = 0;
        for (Applicant person : people) {
            matched += person.check(q);
            person.matched = 0;
        }
        return matched;
    }
}

class Applicant {
    String language;
    String work;
    String position;
    String food;
    int score;
    int matched;

    public Applicant(String[] info) {
        this.language = info[0];
        this.work = info[1];
        this.position = info[2];
        this.food = info[3];
        this.score = Integer.parseInt(info[4]);
    }

    public int check(String[] query) {
        if (query[0].equals("-") | query[0].equals(language)) matched++;
        if (query[1].equals("-") | query[1].equals(work)) matched++;
        if (query[2].equals("-") | query[2].equals(position)) matched++;
        if (query[3].equals("-") | query[3].equals(food)) matched++;
        if (query[4].equals("-") | Integer.parseInt(query[4]) <= score) matched++;

        if (matched == 5) return 1;
        else return 0;
    }
}
