import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Integer>[] graph;
	static int indegrees[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		indegrees = new int[N+1];	// 진입차수 수
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {					// 선후관계 입력
			st = new StringTokenizer(br.readLine());
			int small = Integer.parseInt(st.nextToken());
			int tall = Integer.parseInt(st.nextToken());
			graph[small].add(tall);
			indegrees[tall]++;	// 진입차수 수 증가
		}

		bfs();
		
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<Integer> que = new ArrayDeque<>();
		// 진입차수가 0인 것들을 인큐
		for (int i = 1; i <= N; i++) {
			if (indegrees[i] == 0) {
				que.offer(i);
				indegrees[i]-=1;
				sb.append(i).append(" ");
			}
		}
		
		while(!que.isEmpty()) {
			// 디큐 
			int now = que.poll();
			for (int i : graph[now]) {
					indegrees[i]--;
					if (indegrees[i] == 0) {
						que.offer(i);
						indegrees[i]--;	// 방문처리
						sb.append(i).append(" ");	// 출력
						
				
				}
			}
			
		}
	}
}
