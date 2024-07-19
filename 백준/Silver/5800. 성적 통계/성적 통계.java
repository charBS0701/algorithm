import java.util.*;
import java.io.*;

class Main {
    static int K, N;
    static int[] scores;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            scores = new int[N];
            for (int n=0; n<N; n++) {
                scores[n] = Integer.parseInt(st.nextToken());
            }        
            Arrays.sort(scores);
            int max = scores[N-1];
            int min = scores[0];
            int lg = 0;
            for (int n=1; n<N; n++) {
                lg = Math.max(lg, Math.abs(scores[n]-scores[n-1]));
            }
            
            sb.append("Class ").append(k+1).append("\nMax ").append(max).append(", Min ").append(min).append(", Largest gap ").append(lg).append("\n");
        }
        
        System.out.println(sb);
        
    }

}