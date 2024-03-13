import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int x, y = -1;
	static int count;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) { // 도연이 찾기
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'I') {
					x = i;
					y = j;
					break;
				}
			}
			if (y != -1)
				break;
		}

		solve(x, y);

		System.out.println(count == 0 ? "TT" : count);
	}

	static void solve(int x, int y) {
		visit[x][y] = true;
		if (map[x][y] == 'P')
			count++;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (!isValid(nx, ny) || visit[nx][ny] || map[nx][ny] == 'X')
				continue;

			solve(nx, ny);
		}
	}

	static boolean isValid(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		else
			return false;
	}

}
