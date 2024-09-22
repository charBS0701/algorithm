import java.io.*;
import java.util.*;
public class Main
{
    static int N;
    static List<Integer> list = new ArrayList<>();
    static Deque<Integer> stack = new ArrayDeque<>();
    static long answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int n=0; n<N; n++) {
		    int height = Integer.parseInt(br.readLine());
		    list.add(height);
		}
		
		for (int n=0; n<N; n++) {
		    while (!stack.isEmpty() && stack.peek() <= list.get(n)) {
		        stack.pop();
		    }
		    
		    answer += stack.size();
		    
		    stack.push(list.get(n));
		}
		
		

		System.out.println(answer);
		
	}
}