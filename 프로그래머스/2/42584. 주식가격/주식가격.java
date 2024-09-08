import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.pop();
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            answer[stack.peek()] = len-stack.poll()-1;
        }
            
        return answer;
    }
}