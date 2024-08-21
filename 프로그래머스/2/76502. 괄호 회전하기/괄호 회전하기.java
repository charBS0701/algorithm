import java.util.*;
class Solution {
    static LinkedList<Character> deque = new LinkedList<>();  
    static Deque<Character> stack = new ArrayDeque<>();
    static int answer;
    public int solution(String s) {
        for (int i=0; i<s.length(); i++) {
            deque.add(s.charAt(i));
        }
        
        for (int i=0; i<s.length(); i++) {
            deque.add(deque.pollFirst());
            if(check()) answer++;
        }
        
        return answer;
    }
    
    static boolean check() {
        stack.clear();
        for (char c : deque) {
            if (c=='(' || c=='{' || c=='[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) return false;
            char prev = stack.pop();
            if ((c==')' && prev == '(') || (c=='}' && prev == '{') || (c==']' && prev == '['))
                continue;
            else return false;
            
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}