import java.io.*;
import java.util.*;

public class Main {
    
    static class Edge {
        int a, b, c;
        public Edge(int a, int b, int c) {
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
    
    static int N, M, t;
    static int answer;
    static PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2) -> o1.c-o2.c);
    static int[] parents;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // <= 10000
        M = Integer.parseInt(st.nextToken());   // <= 30000
        t = Integer.parseInt(st.nextToken());   // <= 10
        
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(a,b,c));
        }
        
        makeSet();
        
        int sumT = 0;
        int cnt = 0;
        while (cnt < N-1) {
            Edge ne = pq.poll();
            if (!union(ne.a,ne.b)) continue;
            answer += ne.c + sumT;
            sumT += t;
            cnt++;
        }
        
        System.out.println(answer);
        
    }
    
    static void makeSet() {
        parents = new int[N+1];
        for (int n=1; n<=N; n++) {
            parents[n] = n;
        }
    }
    
    static int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
    
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        parents[rootB] = rootA;
        return true;
    }
    
}