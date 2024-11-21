class Solution {
    
    static int answer = 100_000;
    
    public int solution(int[] diffs, int[] times, long limit) {
        
        int s = 1;
        int e = 100_000;
        int mid;
        
        while (s<=e) {
            mid = (s+e)/2;
            if (solve(diffs, times, limit, mid)) {
                answer = Math.min(answer, mid);
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        
        return answer;
    }
    
    static boolean solve(int[] diffs, int[] times, long limit, int level) {
        int len = diffs.length;
        long sum = 0;
        
        for (int i=0; i<len; i++) {     // 문제순회 시작
            
            if (diffs[i] > level) {     // 못푸는 문제이면
                int dojeon = diffs[i] - level;
                sum += dojeon * (times[i-1] + times[i]);
            }
            
            sum += times[i];
            
            if (sum > limit) return false;
        }
        
        return true;
    }
}