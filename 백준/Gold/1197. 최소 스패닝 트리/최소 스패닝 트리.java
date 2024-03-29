import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 크루스칼
public class Main {
	static int V, E, result;
	static List<Edge> list = new ArrayList<>();
	static int[] parent;
	
	static class Edge{
		int v1, v2, w;
		Edge(int v1, int v2, int w) {
			this.v1=v1; this.v2=v2; this.w=w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Edge(s,e,w));
		}
		
		Collections.sort(list, (e1, e2) -> e1.w - e2.w);  // 정렬

		// 풀이
		makeSet();
		kruskal();
		System.out.println(result);

	}

	static void kruskal() {
		int count = 0;
		for(Edge edge : list) {
			if (count == V-1) break;
			if (!union(edge.v1, edge.v2)) continue;
			result += edge.w;
			count++;
		}
	}
	
	static void makeSet() {
		parent = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}
	static int findSet(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	static boolean union(int x1, int x2) {
		int p1 = findSet(x1);
		int p2 = findSet(x2);
		if (p1 == p2) return false;
		else {
			if (p1 < p2) {
				parent[p2] = parent[p1];
			} else {
				parent[p1] = parent[p2];
			}
			return true;
		}
	}
}