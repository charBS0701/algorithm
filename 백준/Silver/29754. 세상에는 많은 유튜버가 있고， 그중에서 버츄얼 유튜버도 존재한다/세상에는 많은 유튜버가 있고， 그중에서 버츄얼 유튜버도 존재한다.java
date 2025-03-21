import java.util.*;
import java.io.*;

public class Main {
    
    static class Log implements Comparable<Log> {
        String name;
        int day, rTime;
        
        public Log (String name, int day, int rTime) {
            this.name = name;
            this.day = day;
            this.rTime = rTime;
        }
        
        @Override
        public int compareTo(Log ol) {
            if (!name.equals(ol.name)) return name.compareTo(ol.name);
            return this.day - ol.day;
        }
    }
    
    static int N, M;
    static List<Log> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            String[] start = st.nextToken().split(":");
            String[] end = st.nextToken().split(":");
            
            int rTime = (Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1])) - Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            
            if (day <= M) list.add(new Log(name, day, rTime));
        }
        
        Collections.sort(list);
        
        String prevName = null;
        int dayCnt = 0;
        int timeSum = 0;
        int prevWeek = 0;
        boolean flag = true;
        
        for (Log log : list) {
            int week = (log.day - 1) / 7;
            
            if (prevName == null) {     // 첫 버튜버
                prevName = log.name;
                dayCnt = 1;
                timeSum = log.rTime;
                prevWeek = week;
                
                if (week != 0) flag = false;
                continue;                
            }
            
            
            if (!prevName.equals(log.name)) {       // 새로운 버튜버
                flag = true;
                if (prevWeek == (M-1) / 7 && dayCnt >= 5 && timeSum >= 3600) sb.append(prevName).append("\n");
                prevName = log.name;
                dayCnt = 1;
                timeSum = log.rTime;
                prevWeek = week;
                
                if (week != 0) flag = false;
                continue;
            }
            
            if (!flag) continue;
            
            if (week != prevWeek) {
                if (prevWeek + 1 != week || dayCnt < 5 || timeSum < 3600) {     // 가짜 버튜버
                    flag = false;
                } else {
                    dayCnt = 1;
                    timeSum = log.rTime;
                    prevWeek = week;
                }
            } else {
                dayCnt++;
                timeSum += log.rTime;
            }
        }
        
        if (flag && prevWeek == (M-1) / 7 && timeSum >= 3600 && dayCnt >= 5) {
            sb.append(prevName).append("\n");
        }
        
        System.out.println(sb.length() == 0 ? -1 : sb);
        
    }
}