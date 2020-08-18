package org.wtcm.kakao2019.failurerate;

import java.util.Arrays;

public class FailureRate_JY {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] failuredPlayer = new int[N+2];

        for (int stage : stages){
            failuredPlayer[stage]++;
        }
        int total = stages.length;
        Record[] records = new Record[N];
        records[0] = new Record(0,0);
        for (int stage = 1; stage <= N; stage++) {
            if (total != 0) {
                records[stage-1] = new Record(stage, (double)failuredPlayer[stage] / total);
                total -= failuredPlayer[stage];
            }
            else {
                records[stage-1] = new Record(0,0);
            }
        }
        Arrays.sort(records);
        for (int idx = 0; idx < N; idx++) {
            answer[idx] = records[idx].stage;
        }
        return answer;
    }
}
class Record implements Comparable<Record> {
    int stage;
    double failureRate;

    Record(int stage, double failureRate) {
        this.stage = stage;
        this.failureRate = failureRate;
    }

    @Override
    public int compareTo(Record o) {
        if (this.failureRate == o.failureRate)
            return this.stage - o.stage;

        return Double.compare(o.failureRate, this.failureRate);
    }
}
