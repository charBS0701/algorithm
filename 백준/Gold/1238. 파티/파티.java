import java.io.*;
import java.util.*;

class Main {
    
    static class Vertex {
        int v;
        int c;
        public Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
    
    static int N, M, X;
    static List<List<Vertex>> originList = new ArrayList<>();
    static List<List<Vertex>> reverseList = new ArrayList<>();
    static int[] cost;
    static int[] roundX;
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 학생 수
        M = Integer.parseInt(st.nextToken());       // 도로 수
        X = Integer.parseInt(st.nextToken());       // 파티 장소
        
        for (int n=0; n<=N; n++) {
            originList.add(new ArrayList<Vertex>());
            reverseList.add(new ArrayList<Vertex>());
        }
        
        
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            originList.get(from).add(new Vertex(to, weight));
            reverseList.get(to).add(new Vertex(from, weight));
        }
        
        // (N -> X) + (X -> N)
        roundX = new int[N+1];
        
        dijkstra(X, 0, reverseList);        // n -> X 거리 구하기
        dijkstra(X, 0, originList);         // X -> n 거리 구하기
        
        Arrays.sort(roundX);
        System.out.println(roundX[N]);
        
    }
    
    static void dijkstra(int from, int to, List<List<Vertex>> list) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>((o1,o2) -> o1.c - o2.c);
        cost = new int[N+1];
        Arrays.fill(cost, INF);
        
        pq.add(new Vertex(from, 0));
        cost[from] = 0;
        
        while (!pq.isEmpty()) {
            Vertex pv = pq.poll();
            
            if (pv.v == to) break;
            
            if (pv.c > cost[pv.v]) continue;
            
            for (Vertex nv : list.get(pv.v)) {
                if (cost[nv.v] > cost[pv.v] + nv.c) {
                    cost[nv.v] = cost[pv.v] + nv.c;
                    pq.add(new Vertex(nv.v, cost[nv.v]));
                }
            }
            
        }
        
        for (int n=1; n<=N; n++) {
            roundX[n] += cost[n];        
        }
        
    }
}