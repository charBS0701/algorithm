import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        List<Integer> result = new ArrayList<>();
        
        for (int el : score) {
            if (pq.size() < k) {
                pq.add(el);
            } else if (pq.size() >= k && pq.peek() < el) {
                pq.poll();
                pq.add(el);
            }
            result.add(pq.peek());
        }
        
        return result.stream().mapToInt(i -> i).toArray();
        
    }
}