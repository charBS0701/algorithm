import java.time.*;
import java.util.*;
import java.io.*;

class Main {
    static int N;
    static String day;
    static int calc(String str){
        // 기한일과 제출일을 나눔
        String[] days = str.split(" ");
        String[] deadLine = days[0].split("/");
        day = days[1];
        String[] submittedDay = days[1].split("/");
        LocalDate d1 = LocalDate.of(Integer.parseInt(deadLine[2]), Integer.parseInt(deadLine[0]), Integer.parseInt(deadLine[1]));
        LocalDate d2 = null;

        if(deadLine[0].equals("12") && submittedDay[0].equals("1")){
            d2 = LocalDate.of(Integer.parseInt(deadLine[2]) + 1, Integer.parseInt(submittedDay[0]), Integer.parseInt(submittedDay[1]));
            day += "/" + (Integer.parseInt(deadLine[2]) + 1);
        }
        else if(deadLine[0].equals("1") && submittedDay[0].equals("12")){
            d2 = LocalDate.of(Integer.parseInt(deadLine[2]) - 1, Integer.parseInt(submittedDay[0]), Integer.parseInt(submittedDay[1]));
            day += "/"+(Integer.parseInt(deadLine[2]) - 1);
        }
        else if (!d1.isLeapYear() && days[1].equals("2/29")){
            return 366;
        }else{
            d2 = LocalDate.of(Integer.parseInt(deadLine[2]), Integer.parseInt(submittedDay[0]), Integer.parseInt(submittedDay[1]));
            day += "/"+deadLine[2];
        }
        return Period.between(d1, d2).getDays();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        while (N --> 0){
            int n = calc(br.readLine());
            if(n == 0)sb.append("SAME DAY");
            else if(n < 0){
                if(n == -1) sb.append(day).append(" IS").append(' ').append(Math.abs(n)).append(" DAY PRIOR");
                else if(n < -7) sb.append("OUT OF RANGE");
                else sb.append(day).append(" IS").append(' ').append(Math.abs(n)).append(" DAYS PRIOR");
            }
            else{
                if(n == 1) sb.append(day).append(" IS").append(' ').append(Math.abs(n)).append(" DAY AFTER");
                else if(n > 7) sb.append("OUT OF RANGE");
                else sb.append(day).append(" IS").append(' ').append(Math.abs(n)).append(" DAYS AFTER");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}