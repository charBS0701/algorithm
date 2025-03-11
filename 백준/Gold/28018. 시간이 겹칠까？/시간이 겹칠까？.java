import java.io.*;
import java.util.*;

public class Main {
    
    static int N, Q;
    static int INF = 1_000_001;
    static int[] effect = new int[INF+1];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());        // <= 100_000

        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());   // <= 1_000_000
            int e = Integer.parseInt(st.nextToken());
            
            effect[s]++;
            effect[e+1]--;
        }
        
        for (int n=1; n<INF; n++) {
            effect[n] = effect[n] + effect[n-1];
        }
        
        
        Q = Integer.parseInt(br.readLine());        // <= 100_000
        st = new StringTokenizer(br.readLine());
        for (int q=0; q<Q; q++) {
            sb.append(effect[Integer.parseInt(st.nextToken())]).append("\n");
        }
        
        System.out.println(sb);
        
    }
}