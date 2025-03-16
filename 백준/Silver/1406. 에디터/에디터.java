import java.io.*;
import java.util.*;

public class Main {
    
    static int M;
    static Deque<Character> left = new ArrayDeque<>();
    static Deque<Character> right = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i=0; i<s.length(); i++) {
            left.push(s.charAt(i));
        }
        
        M = Integer.parseInt(br.readLine());
        for (int m=0; m<M; m++) {
            String op = br.readLine();
            if (op.equals("L")) {
                if (!left.isEmpty()) right.push(left.pop());
            } else if (op.equals("D")) {
                if (!right.isEmpty()) left.push(right.pop());
            } else if (op.equals("B")) {
                if (!left.isEmpty()) left.pop();
            } else {
                left.push(op.charAt(2));
            }
        }
        
        while (!left.isEmpty()) {
            sb.append(left.removeLast());
        }
        
        while (!right.isEmpty()) {
            sb.append(right.removeFirst());
        }
        
        System.out.println(sb);
        
    }
}