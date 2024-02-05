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
			while (!(stack.isEmpty())) {	// 스택에 원소가 있으면 반복
				if (arr[i] >= arr[stack.peek()]) {	// 스택의 top 보다 새로운 탑이 높으면
					stack.pop();					// pop
				} else {	
					sb.append(stack.peek()).append(" ");	// 스택의 탑이 높으면 그 탑이 답
					break;
				}
			}			
			if (stack.isEmpty()) sb.append(0).append(" ");	// 새로운 탑이 가장 높으면 이전탑 다 지워졌음
			
			stack.push(i);	// 새로운 탑 push
		}
		
		System.out.println(sb);
	}
	
}
