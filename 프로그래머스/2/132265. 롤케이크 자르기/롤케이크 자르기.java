import java.util.*;
class Solution {
    static Map<Integer, Integer> left = new HashMap<>();
    static Map<Integer, Integer> right = new HashMap<>();
    static int answer;
    public int solution(int[] topping) {
        for (int top : topping) {
            right.put(top, right.getOrDefault(top, 0) + 1);
        }
        
        for (int top : topping) {
            left.put(top, left.getOrDefault(top, 0) + 1);
            right.put(top, right.get(top)-1);
            if (right.get(top) == 0) right.remove(top);
            
            if (left.size() == right.size()) answer++;
        }
        
        return answer;
        
    }
}