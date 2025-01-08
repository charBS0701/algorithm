import java.io.*;
import java.util.*;

class Main {
    
    static long A, B;
    static long answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        
        answer = lcm(A,B);
        
        System.out.println(answer);
        
    }
    
    static long gcd(long a, long b) {
        if (b==0)
            return a;
        return gcd(b, a%b);
    }
    
    static long lcm(long a, long b) {
        return a*b/gcd(a,b);
    }
}