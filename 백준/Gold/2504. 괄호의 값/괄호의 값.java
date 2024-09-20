import java.util.*;
import java.io.*;

class Main {
    
    static Deque<Character> stack = new ArrayDeque<Character>();
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int tmp = 1;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                tmp *= 2;
                stack.push('(');
            } else if (c == '[') {
                tmp *= 3;
                stack.push('[');
            } else if (c ==')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }
                
                if (s.charAt(i-1) == '(')
                    answer += tmp;    
                stack.pop();
                tmp /= 2;
                
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }
                
                if (s.charAt(i-1) == '[')
                    answer += tmp;    
                stack.pop();
                tmp /= 3;
            }
            
        }
        
        if (!stack.isEmpty()) answer = 0;
        
        System.out.println(answer);
        
    }
}