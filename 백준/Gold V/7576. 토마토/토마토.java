import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int M, N;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우
	static boolean[][] visited;
	static int maxDay;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로칸 수
		N = Integer.parseInt(st.nextToken()); // 세로칸 수
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) { // 토마토 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 풀이
		bfs();

		// 안익은 토마토 있는지
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					maxDay = -1;
					break;
				}
			}
			if (maxDay == -1)
				break;
		}

		System.out.println(maxDay);
	}

	public static void bfs() {
		Deque<int[]> que = new ArrayDeque<>();
		for (int i = 0; i < N; i++) { // 초기 익은 토마토 inque
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					que.offer(new int[] { i, j, 0 }); // y좌표, x좌표, 익은날짜
					visited[i][j] = true;
				}
			}
		}
		while (!que.isEmpty()) {
			int[] now = que.poll();
			for (int d = 0; d < 4; d++) {
				int ny = now[0] + dy[d];
				int nx = now[1] + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] != 0)
					continue; // 범위보호, 안익은토마토찾기
				que.offer(new int[] { ny, nx, now[2] + 1 });
				visited[ny][nx] = true;
				map[ny][nx] = 1; // 익음
				maxDay = Math.max(maxDay, now[2] + 1); // 모두 익는데 걸리는 시간 업데이트
			}

		}

	}
}
