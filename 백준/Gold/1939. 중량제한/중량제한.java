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
    
    static int N, M, S, E;
    static PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2) -> o2.c - o1.c);
    static int[] parents;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            pq.add(new Edge(h1, h2, k));
        }
        
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());        
        
        makeSet();
        
        // S - E 연결
        while (!pq.isEmpty() && find(S) != find(E)) {
            Edge now = pq.poll();
            union(now.a,now.b);
            answer = Math.min(answer, now.c);
        }
        
        System.out.println(find(S) != find(E) ? 0 : answer);

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
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) return false;
        parents[parentB] = parentA;
        return true;
    }
}