import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, N, M;
	static Queue<Node> que = new ArrayDeque<>(); 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			que.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {			// 큐 입력
				int v = Integer.parseInt(st.nextToken());
				que.offer(new Node(n,v));
			}
			int count = 0;
			while(!que.isEmpty()) {			// 인쇄실행
				Node now = que.poll();
				if(check(now)) {		// 중요도가 가장 큰 수면
					count++;
					if (now.i == M) {
						sb.append(count).append("\n");
						break;
					}
				} else {	// 맨 뒤로
					que.offer(now);
				}
			}
		}
		System.out.println(sb);
		
	}
	
	static boolean check(Node now) {
		for (Node n : que) {
			if (n.v > now.v) {
				return false;
			}
		}
		return true;
	}
	
	static class Node{
		int i;
		int v;
		public Node(int i, int v) {
			this.i=i; this.v = v;
		}
	}
}