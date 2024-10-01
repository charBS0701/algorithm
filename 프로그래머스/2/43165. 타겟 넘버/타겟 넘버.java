import java.util.*;
class Solution {
    static int answer;
    static int len;
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        
        dfs(numbers,0,0,target);
        
        return answer;
    }
    
    static void dfs(int[] numbers, int idx, int sum, int target) {
        if (idx == len) {
            if (sum == target) answer++;
            return;
        }
        
        dfs(numbers, idx+1, sum+numbers[idx], target);
        dfs(numbers, idx+1, sum-numbers[idx], target);
    }
}