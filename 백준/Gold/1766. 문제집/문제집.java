import java.io.*;
import java.util.*;

public class Main
{   
    static int N, M;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] inDegrees;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegrees = new int[N+1];        
        
        for (int n=0; n<=N; n++) {
            adjList.add(new ArrayList<Integer>());
        }
        
        for (int m=1; m<=M; m++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());
            inDegrees[post]++;
            adjList.get(pre).add(post);
        }
        
        bfs();
        
        System.out.println(sb);

	}
	
	static void bfs() {
	    PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o1-o2);
	    for (int n=1; n<=N; n++) {
	        if (inDegrees[n] == 0) pq.add(n);
	    }
	    
	    while (!pq.isEmpty()) {
	        int now = pq.poll();
	        sb.append(now).append(" ");
	        
	        for (int next : adjList.get(now)) {
	            inDegrees[next]--;
	            if (inDegrees[next] == 0) {
	                pq.add(next);
	            }
	        }
	    }
	}
	
}
