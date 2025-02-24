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
    
    static class Node {
        int v, c;
        public Node(int v, int c) {
            this.v=v;
            this.c=c;
        }
    }
    
    static int N, M;
    static int from, to;
    static PriorityQueue<Edge> edgeList = new PriorityQueue<>((o1,o2)->o2.c - o1.c);
    static Set<Integer> set = new HashSet<>();
    static List<List<Node>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;
    static final int INF = 1_000_000_000;
    static int answer = INF;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 섬의 수
        M = Integer.parseInt(st.nextToken());   // 다리의 수
        for (int n=0; n<=N; n++) {
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[N+1];
        
        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   // 출발 섬
            int b = Integer.parseInt(st.nextToken());   // 도착 섬 (양방향)
            int c = Integer.parseInt(st.nextToken());   // 다리 중량
            edgeList.offer(new Edge(a,b,c));
        }   
        
        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());
        
        makeSet(); 
        
        solve(from, to);
        
        dfs(from, INF);
        
        System.out.println(answer);
        
    }
    
    static void solve(int from, int to) {
        while (!edgeList.isEmpty()) {
            Edge e = edgeList.poll();
            if (!union(e.a, e.b)) continue;
            set.add(e.a);
            set.add(e.b);
            adjList.get(e.a).add(new Node(e.b,e.c));
            adjList.get(e.b).add(new Node(e.a,e.c));
            if (find(from) == find(to)) return;
        }
    }
    
    static void dfs(int from, int can) {
        visited[from] = true;
        for (Node node : adjList.get(from)) {
            if (visited[node.v] || !set.contains(node.v)) continue;
            if (node.v == to) {
                answer = Math.min(can, node.c);
                return;
            }
            dfs(node.v, Math.min(can, node.c));
        }
    }
    
    
    static void makeSet() {
        parent = new int[N+1];
        for (int n=1; n<=N; n++) {
            parent[n] = n;
        }
    }
    
    static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
    
    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) {
            return false;
        }
        parent[parentB] = parentA;
        return true;
    }
}