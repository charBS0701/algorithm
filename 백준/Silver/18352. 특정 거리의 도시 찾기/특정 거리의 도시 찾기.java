import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, X; // 도시개수, 도로개수, 거리정보, 출발도시의 번호
	static int depth;
	static boolean[] visited; 
	static int[] result;
	static int resultCnt = 0;
	static List<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		result = new int[N];
		
		graph = new ArrayList[N + 1]; // 그래프 생성
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) { // 도로 입력
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(e);
		}

		// X 에서 풀발해서 거리가 K 인 도시 구하기 // 최단경로 -> BFS
		BFS(X);
		Arrays.sort(result);
		for (int i : result) {
			if (i==0) continue;
			sb.append(i).append("\n");
		}
		
		System.out.println(sb.length()==0 ? -1 : sb);
		
	}

	static void BFS(int start) {
		Deque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { start, depth });
		visited[start] = true;

		while (!que.isEmpty()) {
			int[] now = que.poll();
			if (now[1] == K) {
				result[resultCnt++] = now[0];
			}
			for (int node : graph[now[0]]) {
				if (visited[node])
					continue;
				que.offer(new int[] { node, now[1] + 1 });
				visited[node] = true;
			}
		}

	}

}
