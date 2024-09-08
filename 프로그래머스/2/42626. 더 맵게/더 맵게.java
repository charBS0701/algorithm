import java.util.*;
class Solution {
    static int answer;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        for (int s : scoville) {
            pq.add(s);
        }
        
        while(pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            int mixed = pq.poll() + pq.poll() * 2;
            pq.add(mixed);
            answer++;
        }
        
        
        return answer;
    }
}