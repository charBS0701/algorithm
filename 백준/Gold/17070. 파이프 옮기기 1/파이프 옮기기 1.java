import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
//	static int x = 2, y = 1;
	static int dir = 0; // 가로 : 0, 대각 : 1, 세로 : 2
	static int[] dy = { 0, 1, 1 }; // 옆, 대각선, 밑
	static int[] dx = { 1, 1, 0 };
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 풀이
			solve(1, 2, 0);

		System.out.println(count);
	}

	static void solve(int y, int x, int d) {
		if (y == N && x == N) {
			count++;
			return;
		}
		int ny, nx;
		switch (d) {
		case 0: // 오른쪽 방향일 때
			// 오른쪽
			ny = y + dy[0];
			nx = x + dx[0];
			d = 0;
			if (!(ny > N || nx > N || map[ny][nx] != 0)) { // 조건을 만족하면
				solve(ny, nx, d);
			}
			// 대각선
			ny = y + dy[1];
			nx = x + dx[1];
			d = 1;
			if (!(ny > N || nx > N || map[ny][nx] != 0 || map[y][x + 1] != 0 || map[y + 1][x] != 0)) { // 조건을 만족하면
				solve(ny, nx, d);
			}
			break;
		case 1: // 대각선 방향일 때
			// 오른쪽
			ny = y + dy[0];
			nx = x + dx[0];
			d = 0;
			if (!(ny > N || nx > N || map[ny][nx] != 0)) { // 조건을 만족하면
				solve(ny, nx, d);
			}
			// 대각선
			ny = y + dy[1];
			nx = x + dx[1];
			d = 1;
			if (!(ny > N || nx > N || map[ny][nx] != 0 || map[y][x + 1] != 0 || map[y + 1][x] != 0)) { // 조건을 만족하면
				solve(ny, nx, d);
			}
			// 아래
			ny = y + dy[2];
			nx = x + dx[2];
			d = 2;
			if (!(ny > N || nx > N || map[ny][nx] != 0)) { // 조건을 만족하면
				solve(ny, nx, d);
			}
			break;
		case 2: // 아래 방향일 때
			// 아래
			ny = y + dy[2];
			nx = x + dx[2];
			d = 2;
			if (!(ny > N || nx > N || map[ny][nx] != 0)) { // 조건을 만족하면
				solve(ny, nx, d);
			}
			// 대각선
			ny = y + dy[1];
			nx = x + dx[1];
			d = 1;
			if (!(ny > N || nx > N || map[ny][nx] != 0 || map[y][x + 1] != 0 || map[y + 1][x] != 0)) { // 조건을 만족하면
				solve(ny, nx, d);
			}
			break;
		}
	}

}
