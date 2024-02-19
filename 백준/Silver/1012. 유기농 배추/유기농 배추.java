import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int T, M, N, K;
	static boolean[][] map;
	static boolean visited[][];
	static int count;
	static int dy[] = { -1, 1, 0, 0 }; // 상하좌우
	static int dx[] = { 0, 0, -1, 1 }; // 상하좌우
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			// 초기화
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new boolean[N][M];
			visited = new boolean[N][M];
			for (int k = 0; k < K; k++) { // 배추입력
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = true;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] || !(map[i][j]))	// 방문한 적 있고, 배추가 없는 곳은 pass
						continue;
					bfs(i, j);
					count++;
				}
			}
			sb.append(count).append("\n");

		}
		System.out.println(sb);
	}

	static void bfs(int r, int c) {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { r, c });
		visited[r][c] = true;

		while (!que.isEmpty()) {
			int[] now = que.poll();
			for (int d = 0; d < dx.length; d++) {
				int ny = now[0] + dy[d];
				int nx = now[1] + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx])
					continue; // 범위나감, 방문한 곳 pass
				if (map[ny][nx] == false) { // 배추 없으면 방문처리만
					visited[ny][nx] = true;
					continue;
				} else { // 배추 있으면 bfs
					visited[ny][nx] = true;
					que.offer(new int[] {ny,nx});

				}
			}
		}

	}
}
