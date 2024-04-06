// 1916 최소비용 구하기
//https://www.acmicpc.net/problem/1916
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int A, B;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dis;
    static boolean[] visit;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());    // 도시의 개수 1~1000
        M = Integer.parseInt(br.readLine());    // 버스의 개수 1~100_000
        dis = new int[N+1];
        visit = new boolean[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {    // 버스의 정보
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Edge(e,w));
        }
        
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        // 풀이
        dijkstra(A);
        
        // 출력
        System.out.println(dis[B]);
        
    }
    
    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->o1.w-o2.w);
        dis[start] = 0;
        pq.offer(new Edge(start, 0));
        
        while (! pq.isEmpty()) {
            Edge now = pq.poll();
            
            // visit after poll()
            if (visit[now.v]) continue;
            visit[now.v] = true;
            
            for (Edge next : graph.get(now.v)) {
                if (next.w + dis[now.v] < dis[next.v]) {
                    dis[next.v]=  next.w + dis[now.v];
                    next.w = dis[next.v];
                    pq.offer(next);
                }
            }
        }
    }
    
    static class Edge{
        int v, w;
        public Edge(int v, int w) {
            this.v=v; this.w=w;
        }
    }
}

