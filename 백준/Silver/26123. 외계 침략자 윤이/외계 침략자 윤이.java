import java.io.*;
import java.util.*;

class Main {
    
    static int N, D;
    static long answer;
    static int highest;
    static int[] buildings = new int[300_001];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int height = Integer.parseInt(st.nextToken());
            highest = Math.max(highest, height);
            buildings[height]++;
        }
        
        for (int i=0; i<D; i++) {
            answer += buildings[highest];
            if (highest == 1) break;
            buildings[highest-1] += buildings[highest--];
        }
        
        System.out.println(answer);
    }
    
}