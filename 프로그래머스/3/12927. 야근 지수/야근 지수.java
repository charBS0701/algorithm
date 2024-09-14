import java.util.*;
class Solution {
    static long answer;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
    public long solution(int n, int[] works) {
        for (int work : works) {
            pq.add(work);
        }
        
        for (int i=0; i<n; i++) {
            if (pq.isEmpty()) return 0;
            
            int now = pq.poll();
            if (now == 1) continue;
            else pq.add(now-1);
        }
        
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(),2);
        }
        
        return answer;
    }
}