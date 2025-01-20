import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static long[] nodes;
    static long[] dists;
    static int[] cheaperBeforeIdx;
    static long answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        nodes = new long[N];
        dists = new long[N-1];
        cheaperBeforeIdx = new int[N];
        int idx = 0;
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N-1; n++) {
            long dist = Long.parseLong(st.nextToken());
            dists[n] = dist;
            
        }
        
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            long price = Long.parseLong(st.nextToken());
            nodes[n] = price;
            if (n==0) continue;
            
            if (price >= nodes[cheaperBeforeIdx[n-1]]) {
                cheaperBeforeIdx[n] = cheaperBeforeIdx[n-1];
            } else {
                cheaperBeforeIdx[n] = n;
            }
            
        }
        
        answer += nodes[0] * dists[0];
        for (int n=1; n<N-1; n++) {
            answer += nodes[cheaperBeforeIdx[n]] * dists[n];
        }
        
        System.out.println(answer);
        
    }
}