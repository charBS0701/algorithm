import java.io.*;
import java.util.*;

class Main {
    
    static int T;
    static int A, B;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            sb.append(lcm(A,B)).append("\n");
        }
        
        System.out.println(sb);
        
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