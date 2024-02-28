package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17070_파이프옮기기_eg {
	static int N, cnt;
	static int[][] map;
	static int[][][] delta = {	// 대각선 : 0, 가로 : 1, 세로 : 2
			{{1,1},{0,1},{1,0}},	// 대각선으로 가는 중 	=> 대각선, 가로, 세로
			{{1,1},{0,1},{0,0}}, 	// 가로로 가는 중		 	=> 대각선, 가로,  X
			{{1,1},{0,0},{1,0}}		// 세로로 가는 중 			=> 대각선,  X ,  세로
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];	// 0 dummy

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(1,2,1);	// 가로로 시작 
		System.out.println(cnt);
	}

	// y, x 좌표에서 d 방향으로 현재 이동했다.
	static void dfs(int y, int x, int d) {
		if (y == N && x == N) {
			cnt++;
			return;
		}
		
		// 현재 방향 기준으로 탐색 진행
		// d 를 이용, delta 활용
		for (int i = 0; i < 3; i++) {
			int ny = y + delta[d][i][0];
			int nx = x + delta[d][i][1];
			
			// dummy skip
			if (ny==y && nx == x ) continue;
			
			// range check
			if (ny > N || nx > N || map[ny][nx] == 1) continue;
			
			// 대각선 주변 2곳 체크
			if (i == 0 && (map[ny][nx-1] == 1 || map[ny-1][nx] == 1) )  continue;
			
			dfs(ny, nx, i);	// delta 의 진행방향
		}
		
	}

}
