import java.io.*;
import java.util.*;

public class Main {
    
    static final long MOD = 1_000_000_007;    
    static long sum;
    static long[] heights, acc;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        heights = new long[N];
        acc = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(heights);
        sum = heights[N-1];
        for (int n=N-2; n>=0; n--) {
            acc[n] = (sum + heights[n]) % MOD;
            sum = (sum + acc[n]) % MOD;
        }    
        
        System.out.println(sum);
        
    }
}