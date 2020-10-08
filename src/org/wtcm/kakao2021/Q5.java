package org.wtcm.kakao2021;


import java.text.ParseException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q5 {
    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {
                "01:20:15-01:45:14"
                , "00:40:31-01:00:00"
                , "00:25:50-00:48:29"
                , "01:30:59-01:53:29"
                , "01:37:44-02:02:30"};

//        String play_time = "99:59:59";
//        String adv_time = "25:00:00";
//        String[] logs = {
//                "69:59:59-89:59:59"
//                , "01:00:00-21:00:00"
//                , "79:59:59-99:59:59"
//                , "11:00:00-31:00:00"};
//
//        String play_time = "50:00:00";
//        String adv_time = "50:00:00";
//        String[] logs = {
//                "15:36:51-38:21:49"
//                , "10:14:18-15:36:51"
//                , "38:21:49-42:51:45"};

        System.out.println(solution(play_time, adv_time, logs));
    }

    static String solution(String play_time, String adv_time, String[] logs) {
        Time playTime = new Time(play_time);
        Time advTime = new Time(adv_time);
        PriorityQueue<TimeRange> logArr = new PriorityQueue<>();

        int idx = 0;
        for (String log : logs) {
            String[] tmp = log.split("-");
            logArr.add(new TimeRange(new Time(tmp[0]), new Time(tmp[1])));
        }

        return null;
    }

}

class TimeRange implements Comparable<TimeRange>{
    Time start;
    Time end;

    public TimeRange(Time start, Time end) {
        this.start = start;
        this.end = end;
    }

    public Time playTime() {
        return end.sub(start);
    }

    @Override
    public int compareTo(TimeRange o) {
        return Integer.parseInt(this.start.sub(o.start).HH);
    }
}

class Time implements Comparable<Time> {
    String HH;
    String MM;
    String SS;

    public Time(String time) {
        String[] tmp = time.split(":");
        this.HH = tmp[0];
        this.MM = tmp[1];
        this.SS = tmp[2];
    }

    public Time(String hh, String mm, String ss) {
        this.HH = hh;
        this.MM = mm;
        this.SS = ss;
    }

    public Time sub(Time time) {
        int h = Integer.parseInt(this.HH)-Integer.parseInt(time.HH);
        int m = Integer.parseInt(this.MM)-Integer.parseInt(time.MM);
        if (m < 0) {
            h--;
            m += 60;
        }
        int s = Integer.parseInt(this.SS)-Integer.parseInt(time.SS);
        if (s < 0) {
            m--;
            s += 60;
            if (m < 0) {
                h--;
                m+=60;
            }
        }

        String hh = String.valueOf(h);
        String mm = String.valueOf(m);
        String ss = String.valueOf(s);

        return new Time(hh,mm,ss);
    }

    public Time add(Time time) {
        int h = Integer.parseInt(this.HH)+Integer.parseInt(time.HH);
        int m = Integer.parseInt(this.MM)+Integer.parseInt(time.MM);
        if (m > 60) {
            h++;
            m-= 60;
        }
        int s = Integer.parseInt(this.SS)+Integer.parseInt(time.SS);
        if (s > 60) {
            m++;
            s -= 60;
            if (m > 60) {
                h++;
                m -= 60;
            }
        }

        String hh = String.valueOf(h);
        String mm = String.valueOf(m);
        String ss = String.valueOf(s);

        return new Time(hh,mm,ss);
    }

    @Override
    public String toString() {
        return HH + ":" + MM + ":" + SS;
    }

    @Override
    public int compareTo(Time o) {
        return Integer.parseInt(this.sub(o).HH);
    }
}