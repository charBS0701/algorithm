package boj;
// dfs
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 적록색약_10026_eg {
	static int N, cnt, cnt2;
	static char[][] map;
	static boolean[][] visit, visit2;

	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visit = new boolean[N][N];
		visit2 = new boolean[N][N];

		// 모든 좌표에서 따져본다. 단, visit 하지 않은 곳만
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) { // 일반
					dfs(i, j);
					cnt++;
				}
				if (!visit2[i][j]) { // 적록색약
					dfs2(i, j);
					cnt2++;
				}
			}
		}

		System.out.println(cnt + " " + cnt2);
	}

	// 현재 y, x 로 부터 갈 수 있는 (같은) 곳을 방문을 이어가면서 visit 처리
	static void dfs(int y, int x) {
		visit[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] != map[y][x])
				continue;
			dfs(ny, nx);
		}

	}

	// 현재 y, x 로 부터 갈 수 있는 (같은) 곳을 방문을 이어가면서 visit 처리
	// 단 R, G 하나의 문자로 처리
	static void dfs2(int y, int x) {
		visit2[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit2[ny][nx])
				continue;
			// y,x 가 R 또는 G 일 때, ny, nx 도 R 또는 G 이어야 한다.
			if ((map[y][x] == 'R' || map[y][x] == 'G') && (map[ny][nx] == 'R' || map[ny][nx] == 'G')) {
				dfs2(ny, nx);
			} else if (map[ny][nx] == map[y][x])
				dfs2(ny, nx);
		}
	}
}
