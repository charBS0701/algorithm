import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge> {
    	int from, to, weight;
        
        public Edge(int from, int to, int weight) {
        	super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
        	return Integer.compare(this.weight, o.weight);
		}
	}
    
    static int V;	// 정점 개수
    static Edge[] edgeList;
    static int[] parents;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());		// 정점의 개수 입력
        int E = Integer.parseInt(st.nextToken());	// 간선의 개수 입력
        edgeList = new Edge[E];
        
        // from to weigth 로 간선 정보의 입력이 들어온다고 가정
        for (int i=0; i<E; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            edgeList[i] = new Edge(from, to, weight);
        } // 간선 리스트 생성
        
        // 전처리 : 간선 리스트 오름차순 정렬
        Arrays.sort(edgeList);
        
        // 1. make - set
        make();
        
        // 2. 정렬된 간선하나씩 꺼내어 신장트리 생성
        int weight = 0;
        int cnt = 0;
        for (Edge edge : edgeList) {
        	if (!union(edge.from, edge.to)) continue;
            weight += edge.weight;
            if (++cnt == V-1) break;		// 최소신장트리(MST) 완성
		}
        
        System.out.println(weight);
    	
	}
    
     public static void make() {
     	parents = new int[V+1]; 	// 자신의 부모나 루트(경로 압축) 저장
     	for (int i=1; i<=V; i++) {
        	parents[i] = i;		// 모든 정점을 자신을 루트로
        }
	}
    
    public static int find(int a) {		// a가 속한 트리의 루트 찾기
		if (a == parents[a]) return a;
        
        return parents[a] = find(parents[a]);		// 경로 압축
	}
    
    public static boolean union(int a, int b) {
    	int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;		// a,b 가 같은 트리에 속해있다 => union 불필요
        
        parents[bRoot] = aRoot;
        return true;
	}
}