import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());	// 수열의 크기 (1 ≤ N ≤ 1,000,000)
		st = new StringTokenizer(br.readLine());	
		
		int[] arr = new int[N];						// 수열 		
		int[] result = new int[N];					// 오큰수 담을 배열 
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());	// 수열 입력 (1 ≤ Ai ≤ 1,000,000)	
		
		Stack<Integer> stack = new Stack<>();				// 스택 선언
		
		stack.push(0);
		for (int i =1; i<N; i++) {
			while ( !(stack.isEmpty()) && arr[stack.peek()] < arr[i] ) {
				result[stack.pop()] = arr[i];	// arr[i]이 스택의 top의 오큰수면 저장
			}
			stack.push(i);						// 새로운 수 스택에 저장
		}
		
		while( !(stack.isEmpty())) {
			result[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb);
		
	}
}
