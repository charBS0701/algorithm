package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// MST - 프림
public class sw_하나로_1251_2 {

	static int T, N;
	static long ans;
	static int[][] island;
	static List<List<Edge>> adjList;
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1, e2) -> Long.compare(e1.c, e2.c));
	static boolean[] visit;
	static double E; // 세율 <- 맨 마지막에 적용
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			island = new int[N][2]; // 0:x, 1:y
			// x 좌표
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i][0] = Integer.parseInt(st.nextToken());
			}
			// y 좌표
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i][1] = Integer.parseInt(st.nextToken());
			}
			// E
			E = Double.parseDouble(br.readLine());

			// adjList 생성
			adjList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				adjList.add(new ArrayList<>());
			}
			
			// 풀이
			// 정점을 중심으로
			int size = N * (N - 1) / 2;
			for (int v1 = 0; v1 < N - 1; v1++) {
				for (int v2 = v1 + 1; v2 < N; v2++) {
					Edge edge1 = new Edge(v2, distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]));
					adjList.get(v1).add(edge1);
					Edge edge2 = new Edge(v1, distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]));
					adjList.get(v2).add(edge2);
				}
			}

			visit = new boolean[N];
			pqueue.clear();

			// 프림
			ans = 0;
			int cnt = 1;	// 선택된 정점의 수
			visit[0] = true;
			
			pqueue.addAll(adjList.get(0));	// 시작섬(0) 에서 갈 수 있는 모든 섬을 한꺼번에.
			while( ! pqueue.isEmpty()) {
				Edge edge = pqueue.poll();
				if(visit[edge.v]) continue;
				// 정점선택
				visit[edge.v] = true;
				ans += edge.c;
				cnt++;
				if (cnt == N) break;
				
				for (Edge e : adjList.get(edge.v)) {
					if (visit[e.v]) continue;
					pqueue.offer(e);
				}
			}

			sb.append("#").append(t).append(" ").append(Math.round(ans * E)).append("\n");
		}
		System.out.println(sb);

	}

	static long distance(int x1, int x2, int y1, int y2) {
		return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	// 한 정점에서 (fixed) 갈 수 있는 다른 정점 정보
	static class Edge {
		int v;	// to
		long c;
		
		Edge(int v, long c) {
			this.v = v; this.c = c;
		}
	}
}
