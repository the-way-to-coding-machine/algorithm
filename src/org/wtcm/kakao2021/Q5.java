package org.wtcm.kakao2021;

import java.util.*;

public class Q5 {
    public static void main(String[] args) {

    }

    static class Period {
        Period(int startPoint){
            this.startPoint = startPoint;
        }
        Period(int startPoint, int endPoint){
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }
        int startPoint;
        int endPoint;
        int amount;
        int count;
    }


    static String estimateBestStartPoint(String play_time, String adv_time, String[] logs){
        String result = "";
        List<Period> periods = new ArrayList<Period>();

        String timePeriod = "";
        int startPoint;
        int endPoint;
        for (int i=0; i<logs.length; i++){
            timePeriod = logs[i];
            String[] splitedTimePeriod = timePeriod.split("-");
            startPoint = parseToAmount(splitedTimePeriod[0]);
            endPoint = parseToAmount(splitedTimePeriod[1]);
            periods.add( new Period(startPoint, endPoint) );
        }

        Map<Integer, Period> sections = makeAmountPeriods( periods );

        result = pickBestSection( sections, parseToAmount(play_time), parseToAmount(adv_time) );

        System.out.println(result);
        return result;
    }

    static int parseToAmount(String timeExp){
        String[] splitedTimeExp = timeExp.split(":");
        int hh = Integer.parseInt(splitedTimeExp[0]);
        int mm = Integer.parseInt(splitedTimeExp[1]);
        int ss = Integer.parseInt(splitedTimeExp[2]);
        int total = (hh * 60 * 60) + (mm * 60) + (ss);
        return total;
    }

    static Map<Integer, Period> makeAmountPeriods(List<Period> logPeriods){
        Map<Integer, Period> result = new HashMap<Integer, Period>();

        List<Integer> points = new ArrayList<Integer>();
        for (int i=0; i<logPeriods.size(); i++){
            Period p = logPeriods.get(i);
            points.add(p.startPoint);
            points.add(p.endPoint);
        }

        points.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer p1, Integer p2) {
                return p1 - p2;
            }
        });

        Integer p1, p2;
        for (int i=0; i<points.size() -1; i++){
            p1 = points.get(i);
            p2 = points.get(i +1);
            if (p1 == p2)
                break;
            for (int j=0; j<logPeriods.size(); j++ ) {
                Period logPeriod = logPeriods.get(j);
                boolean p1ContainsPeriod = (logPeriod.startPoint <= p1 && p1 <= logPeriod.endPoint);
                boolean p2ContainsPeriod = (logPeriod.startPoint <= p2 && p2 <= logPeriod.endPoint);
                int amount = p2 - p1;
                if (p1ContainsPeriod || p2ContainsPeriod){
                    Period sectionPeriod;
                    int sectionKey = p1;
                    if (result.containsKey(sectionKey)){
                        sectionPeriod = result.get(sectionKey);
                        sectionPeriod.count += 1;
                    }else{
                        sectionPeriod = new Period(sectionKey);
                        sectionPeriod.amount = amount;
                        sectionPeriod.count = 1;
                        result.put(sectionKey, sectionPeriod);
                    }
                    result.put(sectionKey, sectionPeriod);
                }
            }
        }

        return result;
    }

    static String pickBestSection(Map<Integer, Period> sections, Integer playSeconds, Integer advSeconds){
        String result = "";

        List<Period> sectionList = new ArrayList<>();
        for (Integer key : sections.keySet()){
            Period p = sections.get(key);
            sectionList.add(p);
        }

        sectionList.sort(new Comparator<Period>(){
            @Override
            public int compare(Period p1, Period p2) {
                return p1.startPoint - p2.startPoint;
            }
        });


        int maxAmount = Integer.MIN_VALUE;
        for( int i=0; i<sectionList.size(); i++){
            Period section = sectionList.get(i);
            int testAdvStartPoint = section.startPoint;
            int testAdvEndPoint = section.startPoint + advSeconds;
            int thisAmount = 0;

            for (int j=i+1; j<sectionList.size(); j++){
                Period checkSection = sectionList.get(j);
                int checkStartPoint = checkSection.startPoint;
                int checkEndPoint = checkSection.endPoint;
                boolean p1Contains = testAdvStartPoint <= checkStartPoint && checkStartPoint <= testAdvEndPoint;
                boolean p2Contains = testAdvStartPoint <= checkEndPoint && checkEndPoint <= testAdvEndPoint;
                if (p1Contains || p2Contains){
                    int r1 = testAdvEndPoint - testAdvStartPoint;
                    int r2 = checkStartPoint - checkEndPoint;
                    int collisionDist = collisionDist(testAdvStartPoint, r1, checkEndPoint, r2) ;
                    thisAmount += (collisionDist * checkSection.amount);
                }else{
                    break;
                }
            }

            if (maxAmount < thisAmount){
                maxAmount = thisAmount;
                result = parseTimeExpression(testAdvStartPoint);
            }
        }

        return result;
    }

    static int collisionDist(int ax, int aR, int bx, int bR){
        int dist = (ax - bx) - (aR + bR);
        return dist *-1;
    }

    static String parseTimeExpression(int timeAmount){
        StringBuilder sb = new StringBuilder();
        int hh = timeAmount / (60 * 60);
        int mm = (timeAmount / 60)  % 60;
        int ss = timeAmount % 60;

        if (hh == 0){
            sb.append("00");
        }else if (hh < 10){
            sb.append("0");
            sb.append(String.valueOf(hh));
        }else{
            sb.append(String.valueOf(hh));
        }
        sb.append(":");

        if (mm == 0){
            sb.append("00");
        }else if (mm < 10){
            sb.append("0");
            sb.append(String.valueOf(mm));
        }else{
            sb.append(String.valueOf(mm));
        }
        sb.append(":");

        if (ss == 0){
            sb.append("00");
        }else if (ss < 10){
            sb.append("0");
            sb.append(String.valueOf(ss));
        }else{
            sb.append(String.valueOf(ss));
        }

        return sb.toString();
    }
}
