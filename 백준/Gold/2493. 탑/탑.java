import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());	// N은 1 이상 500,000 이하
		
		arr = new int[N+1]; 		// 1 이상 100,000,000 이하의 정수
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < arr.length; i++) {
			arr[i]  = Integer.parseInt(st.nextToken());
		}
		sb.append(0).append(" ");	// 0번 탑은 무조건 0
		
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(1);
		for (int i = 2; i <= N; i++) {
			while (!(stack.isEmpty())) {	// 스택에 원소가 있으면
				if (arr[i] >= arr[stack.peek()]) {	// 
					stack.pop();
				} else {
					sb.append(stack.peek()).append(" ");
					stack.push(i);
					break;
				}
			}			
			if (stack.isEmpty()) sb.append(0).append(" ");
			
			stack.push(i);
		}
		
		
		
		System.out.println(sb);
	}
	
}
