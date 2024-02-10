import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) { // 미로 입력
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = Character.getNumericValue(input.charAt(j - 1));
			}
		}

		bfs(1, 1);
		System.out.println(map[N][M]);
	}

	public static void bfs(int y, int x) {
		Deque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { y, x });
		visited[y][x] = true;
		while (!que.isEmpty()) {
			int now[] = que.poll();
			for (int k = 0; k < 4; k++) {
				int ny = now[0] + dy[k];
				int nx = now[1] + dx[k];
				if (ny > 0 && nx > 0 && ny <= N && nx <= M) { // 좌표 유효성 검사
					if (map[ny][nx] != 0 && !visited[ny][nx]) { // 갈수 있는 칸 && 방문 검사
						visited[ny][nx] = true;
						map[ny][nx] = map[now[0]][now[1]] + 1; // 깊이 업데이트
						que.add(new int[] { ny, nx });
					}
				}
			}
		}
	}
}
