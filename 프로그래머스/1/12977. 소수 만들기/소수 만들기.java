import java.util.*;
class Solution {
    static int answer;
    static boolean[] isPrime = new boolean[50_000];
    public int solution(int[] nums) {
        Arrays.fill(isPrime, true);
        // get Prime numbers
        for (int i=2; i*i<50_000; i++) {
            if (!isPrime[i]) continue;
            for (int j=i+i; j<50_000; j+=i) {
                isPrime[j] = false;
            }
        }
        
        // // n C 3
        // for (int i=0; i<nums.length-2; i++) {
        //     int sum = nums[i];
        //     for (int j=i+1; j<nums.length-1; j++) {
        //         sum += nums[j];
        //         for (int k=j+1; k<nums.length; k++) {
        //             sum += nums[k];
        //             if (isPrime[sum]) answer++;
        //             sum -= nums[k];
        //         }
        //         sum -= nums[j];
        //     }
        // }
        
        src = nums;
        selected = new boolean[src.length];
        comb(0,0);

        return answer;
    }
    
    static int[] tgt = new int[3];
    static int[] src;
    static boolean[] selected;

    
    static void comb(int srcIdx, int tgtIdx) {
        if (tgtIdx == 3) {
            if (isPrime[Arrays.stream(tgt).sum()]) answer++;
            return;
        }
        
        for (int i=srcIdx; i<src.length; i++) {
            tgt[tgtIdx] = src[i];
            comb(i+1, tgtIdx+1);
        }
        
    }
}