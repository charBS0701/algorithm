import java.io.*;
import java.util.*;

public class Main {

	static int T, A, B;
	static String[] visit = new String[10_000];
	static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			Arrays.fill(visit, null);
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			bfs(A);
			sb.append("\n");
			
		}

		System.out.println(sb);
	}
	
	static void bfs(int A) {
		Deque<Integer> que = new ArrayDeque<>();
		que.offer(A);
		visit[A] = "";
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			int numD = d(now);
			int numS = s(now);
			int numL = l(now);
			int numR = r(now);
			if (visit[numD] == null) {
				visit[numD] = visit[now].concat("D");
				que.offer(numD);
				if (numD == B) {
					sb.append(visit[numD]);
					return;
				}
			}
			if (visit[numS] == null) {
				visit[numS] = visit[now].concat("S");
				que.offer(numS);
				if (numS == B) {
					sb.append(visit[numS]);
					return;
				}
			}
			if (visit[numL] == null) {
				visit[numL] = visit[now].concat("L");
				que.offer(numL);
				if (numL == B) {
					sb.append(visit[numL]);
					return;
				}
			}
			if (visit[numR] == null) {
				visit[numR] = visit[now].concat("R");
				que.offer(numR);
				if (numR == B) {
					sb.append(visit[numR]);
					return;
				}
			}
			
		}
	}
	
	static int d(int num) {
		return 2*num % 10000;
	}
	static int s(int num) {
		return num-1 == -1 ? 9999 : num-1;
	}
	static int l(int num) {
		int result = 0;
		result += num/1000;
		num%=1000;
		result += num/100 * 1000;
		num%=100;
		result += num/10 * 100;
		num%=10;
		result += num%10 * 10;
		return result;
	}
	static int r(int num) {
		int result = 0;
		result += num/1000 * 100;
		num %= 1000;
		result += num/100 * 10;
		num %= 100;
		result += num/10;
		num %= 10;
		result += num * 1000;
		return result;
	}
	
	
}