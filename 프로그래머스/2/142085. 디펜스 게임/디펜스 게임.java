import java.util.*;
class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        for (int ene : enemy) {
            n -= ene;
            pq.offer(ene);
            
            if (n < 0) {
                if (k > 0) {
                    n += pq.poll();
                    k--;
                } else {
                    break;
                }
            }
            
            answer++;
        }
        return answer;
    }
}