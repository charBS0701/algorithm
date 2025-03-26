import java.util.*;
import java.io.*;

public class Main {
    
    static int X, Y, RATE;
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        
        RATE = (int) Math.floor((double) Y * 100 / X);
        
        if (RATE >= 99) {
            System.out.println(-1);
            return;
        }
        
        int left = 1;
        int right = 1_000_000_000;
        
        while (left <= right) {
            int mid = right + (left-right)/2;
            
            if (check(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }  
        }
        
        System.out.println(answer);
        
    }
    
    static boolean check(int mid) {
        int newRate = (int) Math.floor((double) (Y+mid) * 100 / (X+mid));
        if (newRate > RATE) {
            return true;
        }
        return false;
    }
}