import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    static int[] parents;
    static List<Edge> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        for (int m=0; m<M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            list.add(new Edge(a,b,c));
        }
        
        Collections.sort(list);
        
        makeSet();
        
        int totalWeight = 0;
        int edgeCnt = 0;
        while (edgeCnt < N-1) {
            Edge e = list.remove(0);
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
}

