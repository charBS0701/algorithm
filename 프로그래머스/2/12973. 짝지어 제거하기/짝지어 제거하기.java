import java.util.*;
class Solution
{
    static Deque<Character> stack = new ArrayDeque<>();
    public int solution(String s)
    {        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && c==stack.peek()) stack.pop();
            else stack.push(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}