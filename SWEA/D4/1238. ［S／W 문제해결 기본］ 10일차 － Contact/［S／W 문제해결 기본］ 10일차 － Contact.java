import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int N, start, result;
	static List<Integer>[] A;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			A = new ArrayList[101];
			for (int i = 1; i <= 100; i++) {
				A[i] = new ArrayList<Integer>();
			}
			visited = new boolean[101];
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				A[from].add(to);
			}
			
			// 풀이
			bfs(start, 0);
			
			// 출력
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		}
		
		System.out.println(sb);
	}
	static void bfs(int node, int depth) {
		Deque<int[]> que = new ArrayDeque<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
		int maxDepth = depth;
		pq.add(node);
		
		que.offer(new int[] {node, depth});
		visited[node] = true;
		
		while(! que.isEmpty()) {
			int[] now = que.poll();
			
			for(int next : A[now[0]]) {
				if(visited[next]) continue;
				visited[next] = true;
				int newDepth = now[1] + 1;
				que.offer(new int[] {next, newDepth});
				if (newDepth > maxDepth) {
					maxDepth = newDepth;
					pq.clear();
					pq.add(next);	
				} else if(newDepth == maxDepth) {
					pq.add(next);
				}
			}
		}
		
		result = pq.poll();
	}

}
