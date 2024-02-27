import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static int K; // 시작정점
	static List<List<Edge>> adjList = new ArrayList<>();
	static int[] cost; // 시작 정점으로부터의 최소 비용 관리
	static boolean[] visit; // 꺼낼 때
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
	static StringBuilder sb = new StringBuilder();
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		visit = new boolean[V + 1]; // 0 dummy
		cost = new int[V + 1];

		// cost, adjList 초기화
		for (int i = 0; i <= V; i++) {
			adjList.add(new ArrayList<Edge>());
			cost[i] = INF;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList.get(u).add(new Edge(v, w));
		}

		// 풀이
		dijkstra();

		for (int i = 1; i <= V; i++) {
			sb.append(cost[i] == INF ? "INF" : cost[i]).append("\n");
		}

		System.out.println(sb);

	}

	static void dijkstra() {
		// 시작 정점 K
		cost[K] = 0;
		pq.offer(new Edge(K, 0));

		while (!pq.isEmpty()) {

			Edge pe = pq.poll();

			if (visit[pe.v])
				continue;
			visit[pe.v] = true;

			for (Edge ne : adjList.get(pe.v)) {
				if (ne.c + cost[pe.v] < cost[ne.v]) {
					cost[ne.v] = ne.c + cost[pe.v];
					ne.c = cost[ne.v];
					pq.offer(ne);
				}
			}
		}
	}

	static class Edge {
		int v, c;

		public Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}

	}

}
