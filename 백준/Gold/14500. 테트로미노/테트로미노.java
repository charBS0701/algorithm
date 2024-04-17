// 14500 테르로미노
// https://www.acmicpc.net/problem/14500

import java.io.*;
import java.util.*;

public class Main {
	static int R, C, MAX;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 풀이
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				solve(r, c, 0, 0);
				for (int i = 0; i < R; i++) {	// 방문배열 초기화
					Arrays.fill(visit[i], false);
				}
				solve2(r,c);	// ㅗ 모양 테트로미노 검사 
			}
		}

		System.out.println(MAX);

	}
	static void solve2(int r, int c) {
		int sum = map[r][c];
		for (int d = 0; d < 4; d++) {	// 일단 4방향 다 더한다, 못가는 쪽이면 안더함 => 총 합은 최대 + 모양
			int ny = r + dy[d];
			int nx = c + dx[d];
			if (isValid(ny,nx)) sum += map[ny][nx];
		}
		for (int d = 0; d < 4; d++) {
			int tmp = sum;
			int ny = r + dy[d];
			int nx = c + dx[d];
			if (isValid(ny,nx)) tmp -= map[ny][nx];		// 값들이 자연수이기 때문에 최대값을 구하는 것이니 막빼도 상관없음		
			MAX = Math.max(MAX, tmp);
		}
		
	}

	static void solve(int r, int c, int cnt, int sum) {
		cnt++;
		sum += map[r][c];
		visit[r][c] = true;

		if (cnt == 4) {
			MAX = Math.max(MAX, sum);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int ny = r + dy[d];
			int nx = c + dx[d];
			if (isValid(ny, nx) && !visit[ny][nx]) {
				solve(ny, nx, cnt, sum);
				visit[ny][nx] = false;
			}
		}

	}

	static boolean isValid(int r, int c) {
		if (r < 0 || c < 0 || r >= R || c >= C)
			return false;
		return true;
	}
}