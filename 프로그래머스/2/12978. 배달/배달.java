import java.util.*;

class Solution {
    
    static class Node {
        int v,c;
        public Node(int v, int c) {
            this.v=v;
            this.c=c;
        }
    }
    
    static int[] cost;
    static int INF = Integer.MAX_VALUE;
    static List<List<Node>> adjList = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.c-o2.c);
    static int answer = 0;
    
    public int solution(int N, int[][] road, int K) {
        for (int n=0; n<=N; n++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] node : road) {
            adjList.get(node[0]).add(new Node(node[1],node[2]));
            adjList.get(node[1]).add(new Node(node[0],node[2]));
        }
        
        cost = new int[N+1];
        Arrays.fill(cost, INF);
        
        dijkstra(1);
        
        for (int n=1; n<=N; n++) {
            if (cost[n] <= K) answer++;
        }
        
        return answer;
    }
    
    static void dijkstra(int start) {
        cost[start] = 0;
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node pe = pq.poll();
            
            if (cost[pe.v] < pe.c) continue;
            
            for (Node ne : adjList.get(pe.v)) {
                if (cost[pe.v] + ne.c < cost[ne.v]) {
                    cost[ne.v] = cost[pe.v] + ne.c;
                    pq.offer(new Node(ne.v, cost[ne.v]));
                }
            }
        }
    }
}