// 미세먼지 안녕!

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T;
	static int p1, p2; // 공기청정기 위치 행 // 열은 1 고정
	static int result;
	static int[][] map, newMap;
	static int[] dy = { -1, 1, 0, 0 };		// 상하좌우
	static int[] dx = { 0, 0, -1, 1 };

	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R + 1][C + 1];
		newMap = new int[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					if (p1 == 0)
						p1 = i;
					else
						p2 = i;
					map[i][j] = 0;	// 먼지는 없다
				}
			}
		}
		copy(map, newMap);
		
		// 풀이
		for (int t = 0; t < T; t++) {
			// 먼지 확산 -------------------------------------------
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					spread(i, j);
				}
			}
			copy(newMap, map);
			
//			// 디버깅 코드
//			for (int i = 1; i <= R; i++) {
//				for (int j = 1; j <= C; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("-------------------");
			
			// 공기청정기 작동 -------------------------------------------
			purify();
			copy(map, newMap);
		}
		
		// 출력
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				result += map[i][j];
			}
		}
		System.out.println(result);

	}
	
	static void purify() {
		// 위쪽
		for (int j = 3; j <= C; j++) {				// 우로 바람
			map[p1][j] = newMap[p1][j-1];
		}
		map[p1][2] = 0;	// 공기청정기로부터 나온 바람
		for (int i =p1-1; i >=1; i--) {			// 위로 바람
			map[i][C] = newMap[i+1][C];
		}
		for (int j = C-1; j >= 1; j--) {	// 좌로 바람
			map[1][j] = newMap[1][j+1];
		}
		for (int i = 2; i < p1; i++) {		// 밑으로 바람
			map[i][1] = newMap[i-1][1];
		}
		
		// 아래쪽
		for (int j = 3; j <= C; j++) {				// 우로 바람
			map[p2][j] = newMap[p2][j-1];
		}
		map[p2][2] = 0;	// 청정기로부터 나온 바람
		for (int i = p2+1; i <= R; i++) {		// 밑으로 바람
			map[i][C] = newMap[i-1][C];
		}
		for (int j = C-1; j >= 1; j--) {	// 좌로 바람
			map[R][j] = newMap[R][j+1];
		}
		for (int i = R-1; i >= p2+1; i--) {	// 위로 바람
			map[i][1] = newMap[i+1][1];
		}
	}

	static void spread(int r, int c) {
		if (map[r][c] <= 4)
			return;
		int newDust = map[r][c] / 5;
		for (int d = 0; d < 4; d++) {
			int nr = r + dy[d];
			int nc = c + dx[d];
			if (nr <= 0 || nc <= 0 || nr > R || nc > C || ((nr==p1 || nr==p2) && (nc==1)))
				continue;
			newMap[nr][nc] += newDust; // 확산
			newMap[r][c] -= newDust;
		}

	}

	static void copy(int map[][], int cpMap[][]) {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				cpMap[i][j] = map[i][j];
			}
		}
	}

}