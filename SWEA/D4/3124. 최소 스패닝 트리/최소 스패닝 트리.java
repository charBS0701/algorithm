import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

// 쿠르스칼
// cycle check <- 서로소
public class Solution {

	static int T, V, E;
	static long sum; // V - 1 개의 간선의 가중치의 합
	static int[] parent; // 서로소
	static Edge[] edges; // 간선 자료구조
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			parent = new int[V + 1]; // 0 dummy
			edges = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(v1, v2, c);
			}

			// 풀이
			sum = 0;

			// 간선 배열을 가중치 기준 asc 정렬
			Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);
			// 서로소
			makeSet();

			int cnt = 0; // 선택된 간선의 수
			for (int i = 0; i < E; i++) {
				Edge edge = edges[i];
				// 간선 선택 후 간선이 잇는 두 정점에 대해
				if (union(edge.v1, edge.v2)) {
					// 선택
					cnt++;
					sum += edge.c;
				}
				if (cnt == V - 1)
					break;
			}

			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

	static void makeSet() {
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

	}

	static int findSet(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = findSet(parent[x]);
	}

	// 단순히 합치는 작업만 수행 X ==> 서로소이면 합치고 true, 서로소가 아니면 합치지 않고 false 리턴
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px == py)
			return false; // cycle 발생

		if (px < py)
			parent[py] = px;
		else
			parent[px] = py;

		return true;
	}

	static class Edge {
		int v1, v2, c;

		Edge(int v1, int v2, int c) {
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
	}
}
