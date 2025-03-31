import java.io.*;
import java.util.*;

public class Main {
    
    static int N, answer;
    static Deque<Integer> stack = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        
        for (int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            while (!stack.isEmpty() && y < stack.peek()) {
                answer++;
                stack.pop();
            }
            
            if (stack.isEmpty() || stack.peek() < y) {
                if (y!=0) {
                    stack.push(y);
                }
            }
        }
        
        answer += stack.size();
        
        System.out.println(answer);
    
    }
}