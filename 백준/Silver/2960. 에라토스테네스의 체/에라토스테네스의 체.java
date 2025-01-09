import java.io.*;
import java.util.*;

class Main {
    
    static int N, K;
    static boolean[] isPrime;
    static int count;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        
        for (int i=2; i<=N; i++) {
            if (!isPrime[i]) continue;
            for (int j=i; j<=N; j+=i) {
                if (isPrime[j]) {
                    isPrime[j] = false;
                    count++;
                    if (count == K) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }
}