// BFS

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, ccMin;
	static int[][] mat;
	static boolean visit[];
	static int INF = 10000;
	static int distSum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			mat = new int[N][N];
			
			ccMin = INF;
			for (int i = 0; i < N * N; i++) {
				mat[i/N][i%N] = Integer.parseInt(st.nextToken()) == 0 ? INF : 1;
			}
			
			// 풀이
			for (int i = 0; i < N; i++) {
				distSum = 0;
				visit = new boolean[N];
				bfs(i, 0);
				ccMin = Math.min(ccMin, distSum);
			}
			
			
			// 출력
			sb.append("#").append(t).append(" ").append(ccMin).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int s, int dist) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {s,dist});
		visit[s] = true;
		
		while (! que.isEmpty()) {
			int[] now = que.poll();
			distSum += now[1];
			for (int i = 0; i < N; i++) {
				if (mat[now[0]][i] == 1 && !visit[i]) {
					que.offer(new int[] {i, now[1]+1});
					visit[i] = true;
				}
			}
		}
	}
	
}
