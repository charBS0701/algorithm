import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean[] isPrime = new boolean[50_000];
        Arrays.fill(isPrime, true);
        // get Prime numbers
        for (int i=2; i*i<50_000; i++) {
            if (!isPrime[i]) continue;
            for (int j=i+i; j<50_000; j+=i) {
                isPrime[j] = false;
            }
        }
        
        // n C 3
        for (int i=0; i<nums.length-2; i++) {
            int sum = nums[i];
            for (int j=i+1; j<nums.length-1; j++) {
                sum += nums[j];
                for (int k=j+1; k<nums.length; k++) {
                    sum += nums[k];
                    if (isPrime[sum]) answer++;
                    sum -= nums[k];
                }
                sum -= nums[j];
            }
        }

        return answer;
    }
}