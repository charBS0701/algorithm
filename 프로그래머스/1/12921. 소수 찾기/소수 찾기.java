import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for (int i=2; i*i <= n; i++) {
            if (!isPrime[i]) continue;
            for (int j=i*2; j <= n; j+=i) {
                isPrime[j] = false;
            }
        }
        
        for (int i=2; i<=n; i++) {
            if(isPrime[i]) answer++; 
        }
        
        return answer;
    }
}