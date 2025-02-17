import java.io.*;
import java.util.*;

public class Main {
    
    static class Vertex {
        int v, c;
        public Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
    
    static int T, N, M;
    static final int INF = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    
    static List<List<Vertex>> adjList;
    static PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2) -> o1.c-o2.c);
    static int[] cost;
    static int[] from;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        
        for (int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());       // 관계 수 
            M = Integer.parseInt(st.nextToken());       //  정치인 수
            
            adjList = new ArrayList<>();
            cost = new int[M];
            from = new int[M];
            for (int m=0; m<M; m++) {
                adjList.add(new ArrayList<>());
                cost[m] = INF;
                from[m] = -1;
            }
            
            for (int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());   // 친밀도
                adjList.get(x).add(new Vertex(y,z));
                adjList.get(y).add(new Vertex(x,z));
            }
            
            sb.append("Case #").append(t).append(":");
            dijkstra(0,M-1);
        }
        
        System.out.println(sb);
    }
    
    static void dijkstra(int start, int goal) {
        pq.clear();
        
        cost[start] = 0;
        pq.add(new Vertex(start, 0));
        
        while (!pq.isEmpty()) {
            Vertex now = pq.poll();
            if (cost[now.v] < now.c) continue;
            
            for (Vertex next : adjList.get(now.v)) {
                if (cost[next.v] > cost[now.v] + next.c) {
                    cost[next.v] = cost[now.v] + next.c;
                    from[next.v] = now.v;       // 경로 저장
                    pq.add(new Vertex(next.v, cost[next.v]));
                }
            }
        }
        if (cost[goal] == INF) sb.append(" ").append(-1);
        else {
            Deque<Integer> stack = new ArrayDeque<>();
            int now = goal;
            while (now != -1) {
                stack.push(now);
                now = from[now];
            }
            while (!stack.isEmpty()) {
                sb.append(" ").append(stack.pop());
            }
        }
        sb.append("\n");
    }
}