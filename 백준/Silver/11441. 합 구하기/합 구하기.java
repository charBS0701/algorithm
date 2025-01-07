import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    static int[] sums;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sums = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=1; n<=N; n++) {
            sums[n] = sums[n-1] + Integer.parseInt(st.nextToken());
        }
        
        M = Integer.parseInt(br.readLine());
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            sb.append(sums[j]-sums[i-1]).append("\n");
        }
        
        System.out.println(sb);
        
    }
}