import java.io.*;
import java.util.*;

public class Main {
    
    static int N, S;
    static int[] arr;
    static int[] dp;
    static final int INF = Integer.MAX_VALUE;
    static int answer = INF;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        dp = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int n=1; n<=N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            dp[n] = arr[n] + dp[n-1];
        }
        
        int idx1 = 0;
        int idx2 = 0;
        
        while (true) {
            if (idx2 > N) break;
            int tmp = dp[idx2] - dp[idx1];
            
            if (tmp >= S) {
                answer = Math.min(answer, idx2-idx1);
                idx1++;
            } else if (tmp < S) {
                idx2++;
                continue;
            }
        }
    
        System.out.println(answer == INF ? 0 : answer);    
    }
}