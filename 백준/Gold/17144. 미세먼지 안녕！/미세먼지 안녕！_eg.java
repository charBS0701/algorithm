package test.lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시뮬레이션
// T초동안 먼지 확산 - 청정기 실행 반복
// 먼지 확산 2차원 배열의 데이터에 변동 <- 2차원 배열 하나 더 필요
public class BJ_미세먼지안녕_17144 {

	static int R, C, T, ans;
	static int[][] map, tempMap;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int[][] cPos = new int[2][2]; // cPos[0][1] : 위쪽 x

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		tempMap = new int[R][C];

		int cIdx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int n = Integer.parseInt(st.nextToken());

				// 공기청정기 좌표
				if (n == -1) {
					cPos[cIdx][0] = i;
					cPos[cIdx][1] = j;
					cIdx++;
				}

				map[i][j] = n;
			}
		}

		// 시뮬레이션
		for (int i = 0; i < T; i++) {
			// 먼지확산
			spread();
			// 청정기 실행
			clear();
		}

		// 미세먼지의 남은 양 계산
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] <= 0)
					continue;
				ans += map[i][j];
			}
		}

		System.out.println(ans);
	}

	// 먼지 확산
	static void spread() {
		// tempMap 초기화
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tempMap[i][j] = 0;
			}
		}
		// 먼지확산 (map -> tempMap) <= 먼지확산의 결과가 tempMap
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				tempMap[y][x] += map[y][x]; // = 은 이전 단계의 확산의 결과로 y,x 좌표에 값이 있을 수 있는 데 이를 무시
				// 5 미만 확산 X
				if (map[y][x] < 5)
					continue;

				// 확산 양 계산
				int spreadCnt = map[y][x] / 5;

				// 4군데 확산
				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == -1)
						continue;

					tempMap[y][x] -= spreadCnt;
					tempMap[ny][nx] += spreadCnt;
				}
			}
		}

		// tempMap => map 복사
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = tempMap[i][j];
			}
		}

	}

	// 청정기 실행
	static void clear() {
		// tempMap 초기화
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tempMap[i][j] = 0;
			}
		}

		// 2개 공기청정기 - for
		for (int i = 0; i < 2; i++) {

			// 공기청정기 작업(회전 이동) 좌표
			int cy = cPos[i][0];
			int cx = cPos[i][1] + 1; // 공기청정기 바로 오른쪽

			// map -> tempMap
			// #1 공기청정기 ==> 오른쪽
			while (cx < C - 1) {
				tempMap[cy][cx + 1] = map[cy][cx];
				cx++;
			}
			// #2 오른쪽 끝 (위, 아래)
			if (i == 0) { // 위
				while (cy > 0) {
					tempMap[cy - 1][cx] = map[cy][cx];
					cy--;
				}
			} else { // 아래
				while (cy < R - 1) {
					tempMap[cy + 1][cx] = map[cy][cx];
					cy++;
				}
			}
			// #3 오른쪽 끝 => 왼쪽 (천장, 바닥)
			while (cx > 0) {
				tempMap[cy][cx - 1] = map[cy][cx];
				cx--;
			}

			// #4 왼쪽 끝 (공기청정기로)
			if (i == 0) { // 위
				while (cy < cPos[i][0] - 1) {
					tempMap[cy + 1][cx] = map[cy][cx];
					cy++;
				}
			} else { // 아래
				while (cy > cPos[i][0] + 1) {
					tempMap[cy - 1][cx] = map[cy][cx];
					cy--;
				}
			}
		}
		// tempMap => map
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if ( i == 0 || i == R-1 || j==0 || j == C-1 || i == cPos[0][0] || i == cPos[1][0]) {
					map[i][j] = tempMap[i][j];
				}
			}
		}
		
	}

}
