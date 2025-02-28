import java.io.*;
import java.util.*;

public class Main {
    
    static int N, T;
    static int start, end;
    static int day;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = getMinute(st.nextToken());
        end = getMinute(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        int time = start;
        for (int n=0; n<N+1; n++) {
            if (time + T < end) {   // 오늘 배송 가능
                time += T;
            } else {
                day++;      // 다음날 배송
                time = start;
                n--;
            }
        }
        
        String answer = toFormat(time);
        
        sb.append(day).append("\n").append(answer);

        System.out.println(sb);
    }
    
    static int getMinute(String s) {
        int hour = Integer.valueOf(s.split(":")[0]);
        int min = Integer.valueOf(s.split(":")[1]);
        return hour * 60 + min;
    }
    
    static String toFormat(int time) {
        int hour = time/60;
        int min = time%60;
        return String.format("%02d", hour) + ":" + String.format("%02d", min);
    }
}