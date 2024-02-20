package boj;
// dfs 하고 map을 R과 G를 같게 수정하고 다시 dfs
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 적록색약_10026_eg2 {
	static int N, cnt, cnt2;
	static char[][] map;
	static boolean[][] visit;

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

		// 모든 좌표에서 따져본다. 단, visit 하지 않은 곳만
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) { // 일반
					dfs(i, j);
					cnt++;
				}
			}
		}

		// map 에서 R -> G 로 모두 변경, visit 초기화
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R') {	
					map[i][j] = 'G';
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) { // 일반
					dfs(i, j);
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

	
}
