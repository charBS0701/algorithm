import java.io.*;
import java.util.*;

class Main {
    
    static class Edge {
        int a,b,c;
        
        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    static int M, N;
    static StringBuilder sb = new StringBuilder();
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2) -> o1.c - o2.c);
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());       // 집의 수 
            N = Integer.parseInt(st.nextToken());       // 거리 수 
            if (M==0 && N==0) break;
            
            makeSet();
            pq.clear();
            
            int totalEdgeCost = 0;
            for (int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());   // 거리
                
                pq.add(new Edge(x,y,c));
                totalEdgeCost += c;
            }
            
            int count = 0;
            int totalCost = 0;
            while (true) {
                Edge now = pq.poll();
                
                if (!union(now.a,now.b)) continue;
                totalCost += now.c;
                
                count++;
                if (count == M-1) break;
            }
            
            sb.append(totalEdgeCost-totalCost).append("\n");
            
        }
        
        System.out.println(sb);
        
    }
    
    static void makeSet() {
        parent = new int[M];
        for (int m=0; m<M; m++) {
            parent[m] = m;
        }
    }
    
    static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[parent[a]]);
    }
    
    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) return false;
        else if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
        return true;
    }
}