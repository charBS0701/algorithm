import java.io.*;
import java.util.*;

class Main {
    
    static class Vertex {
        int v, c;
        public Vertex(int v, int c) {
            this.v=v;
            this.c=c;
        }
    }
    
    static int N, M, R;
    static int[] items;
    static List<List<Vertex>> adjList = new ArrayList<>();
    static int answer;
    static int cost[][];
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 지역 수
        M = Integer.parseInt(st.nextToken());       // 수색 범위
        R = Integer.parseInt(st.nextToken());       // 길의 개수
        
        items = new int[N+1];
        cost = new int[N+1][N+1];
        
        for (int n=0; n<=N; n++) {
            adjList.add(new ArrayList<>());
            Arrays.fill(cost[n],INF);
        }
        
        st = new StringTokenizer(br.readLine());
        for (int n=1; n<=N; n++) {
            items[n] = Integer.parseInt(st.nextToken());
        }
        
        for (int r=0; r<R; r++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            adjList.get(from).add(new Vertex(to, weight));
            adjList.get(to).add(new Vertex(from, weight));
        }
        
        for (int n=1; n<=N; n++) {
            dijkstra(n);
        }

        System.out.println(answer);
        
    }
    
    static void dijkstra(int start) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>((o1,o2) -> o1.c-o2.c);
        
        pq.add(new Vertex(start, 0));
        cost[start][start] = 0;
        
        while (!pq.isEmpty()) {
            Vertex pv = pq.poll();
            
            if (cost[start][pv.v] < pv.c) continue;
            
            for (Vertex nv : adjList.get(pv.v)) {
                if (cost[start][nv.v] > cost[start][pv.v] + nv.c) {
                    cost[start][nv.v] = cost[start][pv.v] + nv.c;
                    pq.add(new Vertex(nv.v, cost[start][nv.v]));
                }
            }
        }
        
        int totalItems = 0;
        for (int n=1; n<=N; n++) {
            if (cost[start][n] <= M) {
                totalItems += items[n];
            }
        }
        
        answer = Math.max(answer, totalItems);
        
    }
    
}