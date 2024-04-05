// 10773 제로
// https://www.acmicpc.net/problem/10773
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	static int K, sum;
	static Deque<Integer> stack = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			int n = Integer.parseInt(br.readLine());
			if (n==0) sum -= stack.pop();
			else {
				stack.push(n);
				sum += n;
			}
		}
		System.out.println(sum);
	}
}

