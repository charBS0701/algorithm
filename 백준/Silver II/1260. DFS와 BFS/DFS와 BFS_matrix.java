package boj;
// matrix + visit 대신 matrix[i][0] 이용
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

// matrix
public class DFS와BFS_1260_eg {

	static int N, M, V;
	static boolean[][] matrix;
//	static boolean visit[];
	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		matrix = new boolean[N + 1][N + 1];
//		visit = new boolean[N + 1];

		for (int i = 0; i < M; i++) { // 간선입력
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			matrix[s][v] = true;
			matrix[v][s] = true;
		}

		//작은 정점 먼저 방문 처리 필요 X
		
		// dfs
//		visit[V] = true;
		matrix[V][0] = true;
		dfs(V);
//		sb.append("\n");
		sb.setCharAt(sb.length() - 1, '\n');
//		Arrays.fill(visit, false); // 방문초기화
		for (int i = 1; i <= N; i++) {
			matrix[i][0] = false;
		}
		bfs(V);

		sb.setLength(sb.length() - 1); // 마지막 공백문자 지우기

		System.out.println(sb);

	}

	static void dfs(int start) {
		sb.append(start).append(" ");

		for (int i = 1; i <= N; i++) {
			if (!matrix[start][i] || matrix[i][0])
				continue;
//			visit[i] = true;
			matrix[i][0] = true;
			dfs(i);
		}
	}

	static void bfs(int start) {
//		visit[start] = true;
		matrix[start][0] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			sb.append(now).append(" ");

			for (int i = 1; i <= N; i++) {
				if (!matrix[now][i] || matrix[i][0])
					continue;
//				visit[i] = true;
				matrix[i][0] = true;
				queue.offer(i);
			}
		}
	}
}
