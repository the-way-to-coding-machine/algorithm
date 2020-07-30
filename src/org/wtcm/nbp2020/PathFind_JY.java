package org.wtcm.nbp2020;

public class PathFind_JY {
    public int solution(String p) { //"<<>><><<<>"
        int answer = 0;

        char[] road = p.toCharArray();
        if (road[0] == '>' && road[p.length()-1] == '<') {
            return 0;
        }

        if (road[0] == '>') {
            for (int current = road.length-1; current >=0; current--) {
                if (road[current] != '>')
                    break;

                answer++;
            }
        } else {
            for (int current = 0; current < road.length; current++) {
                if (road[current] != '<') {
                    for (int reverse = road.length-1; reverse >= current; reverse--) {
                        if (road[reverse] != '>')   break;
                        answer++;
                    }
                    return answer;
                }
                answer++;
            }
        }
        return answer;
    }
}
