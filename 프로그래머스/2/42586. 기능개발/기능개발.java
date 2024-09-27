import java.util.*;

class Solution {
    static Deque<Integer> days = new ArrayDeque<>();
    public int[] solution(int[] progresses, int[] speeds) {
        
        int len = progresses.length;
        for (int i=0; i<len; i++) {
            int remain = 100-progresses[i];
            int day = remain % speeds[i] == 0 ? remain / speeds[i] : remain / speeds[i] + 1;
            days.add(day);
        }
        
        List<Integer> answer = new ArrayList<>();
        while (!days.isEmpty()) {
            int count = 1;
            int day = days.poll();
            while (!days.isEmpty() && days.peek() <= day) {
                days.poll();
                count++;
            }
            answer.add(count);
        }
        
        int[] answer2 = new int[answer.size()];
        for (int i=0; i<answer.size(); i++){
            answer2[i] = answer.get(i);
        }
        
        return answer2;
    }
}