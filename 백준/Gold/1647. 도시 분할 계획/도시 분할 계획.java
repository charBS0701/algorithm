import java.io.*;
import java.util.*;

class Main {
    
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;
        
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);   
        }
    }
    
    static int N, M;
    static int[] parents;
    static PriorityQueue<Edge> list = new PriorityQueue<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            list.add(new Edge(a,b,c));
        }
        
        makeSet();
        
        int totalWeight = 0;
        int edgeCnt = 0;
        while (edgeCnt < N-2) {
            Edge e = list.poll();
            int from = e.from;
            int to = e.to;
            
            if (!union(from,to)) continue;   // 같은 트리에 속하면 pass
            totalWeight += e.weight;
            edgeCnt++;
        }
        
        System.out.println(totalWeight);
        
    }
    
    static void makeSet() {
        parents = new int[N+1];
        for (int n=1; n<=N; n++) {
            parents[n] = n;
        }
    }
    
    static int findSet(int a) {
        if (a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }
    
    static boolean union(int a, int b) {
        int parentA = findSet(a);
        int parentB = findSet(b);
        
        if (parentA == parentB) return false;
        else if (parentA < parentB) {
            parents[parentB] = parentA;
        } else {
            parents[parentA] = parentB;
        }
        return true;
    }
    

}

