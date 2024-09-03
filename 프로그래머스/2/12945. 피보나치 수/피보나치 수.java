import java.util.*;
class Solution {
    static int answer;
    public int solution(int n) {
        int prev0 = 0;
        int prev1 = 1;
        
        for (int i=2; i<=n; i++) {
            int tmp = (prev0 + prev1) % 1234567;
            if (i==n) {
                answer = tmp;
            }            
            prev0 = prev1;
            prev1 = tmp;
        }
        
        return answer;
    }
}