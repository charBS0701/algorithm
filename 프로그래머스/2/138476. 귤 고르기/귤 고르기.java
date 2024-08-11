import java.util.*;
class Solution {
    static int MAX_VALUE = 10_000_000;
    static int answer;
    static int[] count = new int[MAX_VALUE + 1];
    
    public int solution(int k, int[] tangerine) {
        for (int n : tangerine) count[n]++;
        Arrays.sort(count);
        
        for (int i = MAX_VALUE; i >= 0; i--) {
            answer++;
            if (k <= count[i]) break;
            else k -= count[i];
        }
        
        return answer;
    }
}