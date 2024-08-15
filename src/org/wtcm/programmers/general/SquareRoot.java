package org.wtcm.programmers.general;

class SquareRoot {
    public long solution(long n) {
        long answer = -1;
        double x = Math.sqrt(n);

        if(x - (int)(x) > 0) {
            return answer;
        }

        answer = (long)(Math.pow(x+1, 2));
        return answer;
    }
}