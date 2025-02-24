import java.io.*;
import java.util.*;

public class Main {
    
    
    static int a, b;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            sb.append(lcm(a,b)).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static long lcm(int a, int b) {
        return (long) a * b / gcd(a,b);
    }
    
    static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b, a%b);
    }
}