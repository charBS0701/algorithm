package algorithm;
// dfs 로 풀어서 시간초과 남 => 최단경로 탐색은 BFS 사용하기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로탐색 {

	static int N, M;
	static int[][] map;
	static int min, count;
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
		min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) { // 미로 입력
			String input = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = Character.getNumericValue(input.charAt(j-1));
			}
		}

		dfs(1, 1);
		System.out.println(min);
	}

	public static void dfs(int y, int x) {
		visited[y][x] = true;
		count++;
		if (y==N && x==M) {		// 기저조건 
			min = Math.min(min, count);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny <= 0 || nx <= 0 || ny > N || nx > M 
					|| map[ny][nx] == 0 || visited[ny][nx]) continue;
			dfs(ny,nx);
			count--;
			visited[ny][nx] = false;
		}
	}
}
