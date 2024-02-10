import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N,M,V;
	static List<Integer> graph[];
	static List<Integer> graph2[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		graph2 = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
			graph2[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {	// 노드입력
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(e);
			graph2[s].add(e);
			graph[e].add(s);
			graph2[e].add(s);
		}
		
		for (int i = 1; i < N+1; i++) {  // 원소 정렬
			Collections.sort(graph[i]);
			Collections.sort(graph2[i]);
		}
		
		visit = new boolean[N+1];
				
		dfs(V);
		sb.append("\n");
		for (int i = 1; i < N+1; i++) {	// visit 초기화
			visit[i] = false;
		}
		bfs(V);
		
		System.out.println(sb);
		
	}
	
	static void dfs(int start) {
		visit[start] = true;
		sb.append(start).append(" ");
		while (!graph[start].isEmpty()) {
			int nextNode = graph[start].get(0);
			if (visit[nextNode]) {	// 방문한 노드 패스
				graph[start].remove(0);
				continue;
			} else {
				dfs(nextNode);
			}
		}
		
	}
	
	static void bfs(int start) {
		Deque<Integer> que = new ArrayDeque<>();
		visit[start] = true;
		que.offer(start);
		while (!que.isEmpty()) { 
			int node = que.poll();
			sb.append(node).append(" ");
			while (!graph2[node].isEmpty()) {
				if (visit[graph2[node].get(0)]) { 	// 방문한 노드 패스
					graph2[node].remove(0);
					continue;
				} else {
				int nextNode = graph2[node].remove(0);
				que.offer(nextNode);
				visit[nextNode] = true;
				}
			}
		}
	}
}
