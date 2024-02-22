package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 프림
// cycle check <- visit
public class SW_최소스패닝트리_3124_2 {

	static int T, V, E;
	static long sum; // V - 1 개의 간선의 가중치의 합

	static List<List<Edge>> adjList; // 인접 리스트
	static boolean[] visit; // 방문(선택) 체크

	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			adjList = new ArrayList<>();
			for (int i = 0; i <= V; i++) { // 0 dummy
				adjList.add(new ArrayList<>());
			}
			visit = new boolean[V + 1];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				adjList.get(v1).add(new Edge(v2, c));
				adjList.get(v2).add(new Edge(v1, c));
			}

			// 풀이
			sum = 0;
			pqueue.clear();

			prim();

			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
	static void prim() {
		// 시작 정점 1번 출발 (다른 번호도 상관없음)
		int cnt = 1;
		visit[1] = true;
		
		pqueue.addAll(adjList.get(1));	// 1번 정점에서 갈 수 있는 모든 정점, 간선을 담는다.
		
		while( !pqueue.isEmpty() ) {
			Edge edge = pqueue.poll();
			if( visit[edge.v] ) continue;
			
			visit[edge.v]= true;
			sum += edge.c;	// 최소 비용 합 계산
			
			cnt++;
			if (cnt==V) break; 	// 모든 정점을 선택
			
//			pqueue.addAll(adjList.get(edge.v)); // 이미 방문한 정점이 포함된다.
			
			List<Edge> temp = adjList.get(edge.v);
			int size = temp.size();
			for (int i = 0; i < size; i++) {
				Edge e = temp.get(i);
				if (!visit[e.v]) pqueue.add(e); 
			}
			
		}
	}

	// 특정 정점에서부터 갈 수 있는 간선
	// 시작정점 X <= 다른 자료구조에 시작정점을 관리 3 -> 2, 3 -> 4
	static class Edge {
		int v, c;

		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
}
