import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static Deque<Integer> que = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}
		
		while (true) {
			if (que.size()<=1) break;
			que.poll();
			que.offer(que.poll());
		}
		
		System.out.println(que.peek());
	}

}
