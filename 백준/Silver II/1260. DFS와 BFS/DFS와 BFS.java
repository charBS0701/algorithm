import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static ArrayList<Integer>[] a;
	static StringBuilder sb = new StringBuilder();
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		a = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) { // 그래프 생성
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) { // 간선입력
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			a[s].add(v);
			a[v].add(s);
		}
		
		for (int i = 0; i <= N; i++) {
			Collections.sort(a[i]);
		}

		// 풀이
		dfs(V);
		sb.append("\n");
		Arrays.fill(visited, false); // 방문초기화
		bfs(V);

		System.out.println(sb);

	}
	static void dfs(int start) {
		
		visited[start] = true;
		sb.append(start).append(" ");
		for (int i = 0; i < a[start].size(); i++) {
			int next = a[start].get(i);
			if (visited[next]) continue;
			dfs(next);
		}
	}

	static void bfs(int start) {
		Deque<Integer> que = new ArrayDeque<>();
		que.offer(start);
		visited[start] = true;

		while (!que.isEmpty()) {
			int now = que.poll();
			sb.append(now).append(" ");
			for (int i = 0; i < a[now].size(); i++) {
				int next = a[now].get(i);
				if (visited[next])
					continue;
				que.offer(next);
				visited[next] = true;
			}
		}
	}
}
