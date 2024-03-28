import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, n;
	static boolean flag;
	static boolean[] visit;
	static List<Dot> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			list.clear();
			flag = false;
			n = Integer.parseInt(br.readLine());
			visit =  new boolean[n+2];		// 편의점 방문 초기화
			visit[n+2-1] = true;
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));	// 집
			for (int i = 0; i < n; i++) {	// 편의점 입력
				st = new StringTokenizer(br.readLine());
				list.add(new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			st = new StringTokenizer(br.readLine());
			list.add(new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));	// 펜타포트
			
			// 풀이
			if (canGo(list.get(0), list.get(list.size()-1))) {
				sb.append("happy\n");
				continue;
			}
			
			bfs(0);
			
			sb.append(flag ? "happy\n" : "sad\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int idx) {
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(idx);
		visit[idx] = true;
		
		while ( ! que.isEmpty()) {
			int now = que.poll();
			if (canGo(list.get(now), list.get(list.size()-1))) {
				flag = true;
				return;
			}
			for (int i = 1; i < n+1; i++) {	
				if (visit[i] || !canGo(list.get(now),list.get(i))) continue;
				que.offer(i);
				visit[i] = true;
			}
			
		}
		
		
	}
	
	static boolean canGo(Dot d1, Dot d2) {
		if (Math.abs(d1.x-d2.x) + Math.abs(d1.y-d2.y) > 1000 ) return false;
		else return true;
	}
	
	static class Dot{
		int x, y;
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
