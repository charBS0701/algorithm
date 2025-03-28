import java.io.*;
import java.util.*;

public class Main {
    
    static int N, answer;
    static Deque<Character> stack = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for (int n=0; n<N; n++) {
            char[] arr = br.readLine().toCharArray();
            for (char c : arr) {
                if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            
            if (stack.isEmpty()) {
                answer++;
            }
            
            stack.clear();
            
        }
        
        System.out.println(answer);
        
    }
}