import java.io.*;
import java.util.*;
import java.time.*;

public class Main {
    
    static int N, T;
    static LocalTime start, end;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = LocalTime.parse(st.nextToken());
        end = LocalTime.parse(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        int n=0;    // 보낸 택배수
        int day=0;  // 경과한 날짜
        LocalTime now = LocalTime.of(start.getHour(),start.getMinute());
        while (n<N+1) {
            if (now.plusMinutes(T).isBefore(end))   { // 해당 날에 택배 보낼 수 있음
                n++;
                now = now.plusMinutes(T);
            } else {                        // 내일 보내자
                day++;
                now = LocalTime.of(start.getHour(),start.getMinute());
            }
        }
        
        sb.append(day).append("\n").append(now.toString());
        System.out.println(sb);
        
    }
}