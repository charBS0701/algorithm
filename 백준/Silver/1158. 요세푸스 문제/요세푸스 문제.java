import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> que = new ArrayDeque<>();
	
	static int N,K;
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// (1 ≤ K ≤ N ≤ 5,000)
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}
		sb.append("<");
		while(!(que.isEmpty())) {
			for (int i = 0; i < K-1; i++) {
				que.offer(que.poll());
			}
			if (que.size()==1) sb.append(que.poll());
			else sb.append(que.poll()).append(", ");
		}
		
		sb.append(">");
		System.out.println(sb);
	}

}
