import java.util.*;
import java.io.*;

class Main {
    static int N, K;    // 1 <= N <= 100_000, 1<= K <= 1_000_000_000
    static int[] arr;
    static int[] dif;
    static long answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        dif = new int[N/2];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        
        for (int n=0; n < N/2; n++) {
            dif[n] = Math.abs(arr[n] - arr[N-n-1]);
            answer += dif[n] / K;
            dif[n] %= K;
            
            if (dif[n] > Math.abs(dif[n]-K)) {
                answer += 1 + Math.abs(dif[n]-K);
            } else {
                answer += dif[n];
            }
        }
        
        System.out.println(answer);
        
    }
    
}