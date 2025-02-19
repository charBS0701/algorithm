import java.io.*;
import java.util.*;

public class Main {
    
    static class Edge {
        int v,c;
        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
    
    static int N, M, FROM, TO;
    static List<List<Edge>> adjList = new ArrayList<>();
    static int[] cost;
    static int[] origin;
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        cost = new int[N+1];
        origin = new int[N+1];
        for (int n=0; n<=N; n++) {
            adjList.add(new ArrayList<>());
            cost[n] = Integer.MAX_VALUE;
            origin[n] = -1;
        }
        
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(from).add(new Edge(to,c));
        }
        
        st = new StringTokenizer(br.readLine());
        FROM = Integer.parseInt(st.nextToken());
        TO = Integer.parseInt(st.nextToken());
        
        
        dijkstra(FROM, TO);
        
        System.out.println(sb);
        
    }
    
    static void dijkstra(int from, int to) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.c,o2.c));
        pq.add(new Edge(from, 0));
        cost[from] = 0;
        
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (now.c > cost[now.v]) continue;
            
            for (Edge next : adjList.get(now.v)) {
                if (cost[next.v] > cost[now.v] + next.c) {
                    cost[next.v] = cost[now.v] + next.c;
                    pq.add(new Edge(next.v, cost[next.v]));
                    origin[next.v] = now.v;
                }
            }
        }
        
        int tmp = TO;
        int cnt = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (tmp != -1) {
            stack.push(tmp);
            tmp = origin[tmp];
            cnt++;
        }
        
        sb.append(cost[TO]).append("\n").append(cnt).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
    }
}