import java.io.*;
import java.util.*;

public class Main
{
    static class Edge {
        int v, c;
        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
    
    static int N, E;
    static int v1, v2;  // 반드시 지나야 하는 두 정점
    static List<List<Edge>> adjList = new ArrayList<>();
    static int[] cost1, costV1, costV2;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());   // 정점갯수
	    E = Integer.parseInt(st.nextToken());   // 간선갯수
	    
	    cost1 = new int[N+1];
	    costV1 = new int[N+1];
	    costV2 = new int[N+1];
	    
	    for (int n=0; n<=N; n++) {
	        adjList.add(new ArrayList<Edge>());
	    }
	    
	    for (int e=0; e<E; e++) {
	        st = new StringTokenizer(br.readLine());
	        int from = Integer.parseInt(st.nextToken());
	        int to = Integer.parseInt(st.nextToken());
	        int weight = Integer.parseInt(st.nextToken());
	        
	        adjList.get(from).add(new Edge(to, weight));
	        adjList.get(to).add(new Edge(from, weight));
	        
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    v1 = Integer.parseInt(st.nextToken());
	    v2 = Integer.parseInt(st.nextToken());
	    
	    dijkstra(1, cost1);
	    dijkstra(v1, costV1);
	    dijkstra(v2, costV2);
	    
	    if (cost1[N] == INF) System.out.println(-1);
	    else {
	        int path1 = cost1[v1] + costV1[v2] + costV2[N];
	        int path2 = cost1[v2] + costV2[v1] + costV1[N];
	        System.out.println(Math.min(path1, path2));
	    }
	    
	}
	
	public static void dijkstra(int from, int[] cost) {
	    Arrays.fill(cost, INF);
	    visited = new boolean[N + 1];
	    PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2) -> (o1.c-o2.c));
	    pq.offer(new Edge(from,0));    // 시작점 입력
	    cost[from] = 0;
	    
	    while (!pq.isEmpty()) {
	        Edge pe = pq.poll();
	        
	        if (pe.c > cost[pe.v]) continue;    // 가지치기 : 현재 꺼낸 노드가 이미 최소 비용이 아니라면 스킵
	        if (visited[pe.v]) continue;     // 방문 pass
	        
	        visited[pe.v] = true;
	        
	        for (Edge ne : adjList.get(pe.v)) {
	            if (!visited[ne.v] &&
	                    ne.c + cost[pe.v] < cost[ne.v])
	                    cost[ne.v] = ne.c + cost[pe.v];
	                pq.add(new Edge(ne.v, cost[ne.v]));
	        }
	    }
	}
}
