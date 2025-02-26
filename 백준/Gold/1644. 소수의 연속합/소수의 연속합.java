import java.io.*;
import java.util.*;

public class Main {
    
    static int answer;
    static int N;
    static boolean[] isPrime;
    static List<Integer> list = new ArrayList<>();
    static long[] sum;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // <= 4_000_000
        isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        getPrime();
        
        for (int n=2; n<=N; n++) {      // 소수 리스트
            if (!isPrime[n]) continue;
            list.add(n);
        }
        
        sum = new long[list.size()+1];
        sum[0] = 0;
        for (int n=1; n<=list.size(); n++) {     // 구간합
            sum[n] = (long) sum[n-1] + list.get(n-1);
        }
        
        
        int left = 0;
        int right = 0;
        while (left <= right && right < sum.length) {
            long v = sum[right] - sum[left];
            if (v == N) {
                answer++;
                left++;
                right++;
            } else if (v < N) {
                right++;
            } else {
                left++;
            }
        }        
        
        System.out.println(answer);
        
    }
    
    
    static void getPrime() {
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i=2; i*i<=N; i++) {
            if (!isPrime[i]) continue;
            for (int j=i+i; j<=N; j+=i) {
                isPrime[j] = false;
            }
        }
    }
}