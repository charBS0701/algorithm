package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정사각형방_eg_DFS_MEMOIZATION {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map; // N (1 ≤ N ≤ 10^3)
	static int[][] memoi;
	static int NO;
	static int COUNT;
	static int N;
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			memoi = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 플이
			NO = 0;
			COUNT = 1;

			// 모든 좌표에서 다 시도해보고 그 각각의 결과 중 최선을 선택
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int no = map[i][j];
					int cnt = dfs(i, j);
					
					// 문제 처리
					if (cnt > COUNT) {
						COUNT = cnt;
						NO = no;
					} else if (cnt == COUNT) {
						NO = (no < NO) ? no : NO;
					}
				}
			}

			sb.append("#" + t + " ").append(NO + " ").append(COUNT).append("\n");

		}
		System.out.println(sb);
	}

	public static int dfs(int y, int x) {
		// 이미 다른 dfs에 의해 memoi 가 계산되어 있으면 그걸 재사용
		if (memoi[y][x] != 0) return memoi[y][x];

		// 이후 조건에 맞는 더 갈 수 있는 곳 방문
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] == map[y][x] + 1) {
				return memoi[y][x] = dfs(ny,nx) + 1;
			}
		}
		
		// 더 이상 y, x 에서 갈 곳이 없다.
		return memoi[y][x] = 1;
	}
}
