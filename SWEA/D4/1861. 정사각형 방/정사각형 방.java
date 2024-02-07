import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map; // N (1 ≤ N ≤ 10^3)
	static int maxOrigin;
	static int maxCount;
	static int N;
	static boolean[][] visit;
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			maxOrigin = Integer.MAX_VALUE;
			maxCount = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 처음 출발해야하는 방 번호(여러개면 작은것), 최대 이동가능 방 수 출력
			visit = new boolean[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dfs(i, j, 0, map[i][j]);
				}
			}

			sb.append("#" + t + " ").append(maxOrigin + " ").append(maxCount).append("\n");

		}
		System.out.println(sb);
	}

	public static void dfs(int i, int j, int count, int origin) {
		visit[i][j] = true;
		++count;
		if (count >= maxCount) {
			if (count == maxCount)
				maxOrigin = Math.min(origin, maxOrigin);
			else maxOrigin = origin;
			maxCount = count;
		}

		for (int k = 0; k < 4; k++) {
			int ny = i + dy[k];
			int nx = j + dx[k];

			if (ny < 1 || nx < 1 || ny > N || nx > N || map[ny][nx] != map[i][j] + 1)
				continue;
			dfs(ny, nx, count, origin);
		}

	}
}
