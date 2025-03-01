import java.util.*;

class Solution {
    
    static boolean[] isPrime = new boolean[10_000_000];
    static char[] tgt = new char[7];
    static boolean[] visited = new boolean[7];
    static int answer = 0;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        Arrays.fill(isPrime, true);
        
        getPrime();
        perm(numbers, 0);        
        
        return answer;
    }
    
    static void perm(String numbers, int tgtIdx) {
        // 소수 확인
        if (tgtIdx != 0) {
            int result = Integer.valueOf(String.valueOf(tgt).substring(0,tgtIdx));
            if (!set.contains(result) && isPrime[result]) {
                answer++;
                set.add(result);
                // System.out.println(result);
            }
        }
            
        if (tgtIdx == numbers.length()) {
            return;
        }
        
        for (int i=0; i<numbers.length(); i++) {
            if (visited[i]) continue;
            
            tgt[tgtIdx] = numbers.charAt(i);
            visited[i] = true;
            perm(numbers, tgtIdx+1);
            visited[i] = false;
        }
        
    }   
    
    static void getPrime() {
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i=2; i*i<10_000_000; i++) {
            for (int j=i*i; j<10_000_000; j+=i) {
                isPrime[j] = false;
            }
        }
    }
}

