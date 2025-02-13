import java.io.*;
import java.util.*;

public class Main {
    
    static class God {
        int x,y;
        public God(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static class Edge {
        int a,b;
        double c;
        public Edge(int a, int b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    static int N, M;
    static God[] gods;
    static int[] parents;
    static PriorityQueue<Edge> edgeList = new PriorityQueue<>((o1,o2) -> Double.compare(o1.c,o2.c));
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());        // 우주신 수
        M = Integer.parseInt(st.nextToken());        // 통로 수 
        
        gods = new God[N+1];
        for (int n=1; n<=N; n++) {      // 우주신 좌표 입력
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            gods[n] = new God(x,y);
        }
                
        for (int i=1; i<=N-1; i++) {    // 간선 입력
            for (int j=i+1; j<=N; j++) {
                double dis = getDis(i,j);
                edgeList.add(new Edge(i,j,dis));
            }
        }
        
        makeSet();        
        
        int pathCnt = 0;
        for (int m=0; m<M; m++) {       // 이미 만들어진 통로 입력
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (union(a,b)) pathCnt++;
        }
        
        double accDis = 0.0;
        while (!edgeList.isEmpty()) {
            Edge e = edgeList.poll();
            if (!union(e.a,e.b)) continue;      // 사이클
            accDis += e.c;
            if (++pathCnt == N-1) break;
        }
        
        System.out.printf("%.2f", accDis);
        
    }
    
    static double getDis(int a, int b) {
        return Math.sqrt(Math.pow((double)gods[a].x - gods[b].x,2) + Math.pow((double)gods[a].y - gods[b].y,2));
    }
    
    static void makeSet() {
        parents = new int[N+1];
        for (int n=1; n<=N; n++) {
            parents[n] = n;
        }
    }
    
    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    
    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) return false;
        parents[parentB] = parentA;
        return true;
    }
}