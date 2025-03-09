import java.io.*;
import java.util.*;

public class Main {
    
    static class Job {
        int t, p;
        public Job(int t, int p) {
            this.t=t;
            this.p=p;
        }
    }
    
    static int N;
    static Job[] list;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        list = new Job[N+1];
        dp = new int[N+1];
        for (int n=1; n<=N; n++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            list[n] = new Job(t,p);
        }
        
        for (int n=1; n<=N; n++) {
            dp[n] = Math.max(dp[n], dp[n-1]);
            int payDay = n + list[n].t - 1;
            if (payDay > N) continue;
            dp[payDay] = Math.max(dp[payDay], dp[n-1] + list[n].p);
        }
        
        int max = 0;
        for (int n=1; n<=N; n++) max = Math.max(max, dp[n]);
        
        System.out.println(max);
        
    }
}