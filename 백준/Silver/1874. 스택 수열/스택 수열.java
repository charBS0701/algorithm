import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	// (1 ≤ n ≤ 100,000)
		List <Integer> arr = new ArrayList<>();
		Stack <Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr.add(num);
			
		} 
		
		int count = 1;
		for (int i=0; i<n; i++) {
			int num = arr.get(i);
			while (num >= count) {
				stack.add(count++);
				sb.append("+\n");
			}
			if (stack.get(stack.size()-1) == num) {
				stack.pop();
				sb.append("-\n");
			} else if (stack.get(stack.size()-1) > num){	// 안되다가 그냥 else에서 이거 조건 붙이니 됨 // 스택의 top < num 인경우도 있다는말 ?
				System.out.println("NO");
				return;
			}
		}	
		
		System.out.print(sb);
		
	}
}

