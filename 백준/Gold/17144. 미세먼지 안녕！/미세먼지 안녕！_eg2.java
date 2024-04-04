package test.lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시뮬레이션
// T초동안 먼지 확산 - 청정기 실행 반복
// 먼지 확산 2차원 배열의 데이터에 변동 <- 2차원 배열 하나 더 필요
public class BJ_미세먼지안녕_17144_2 {

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
    public static void clear() {
        
        // 이전 문제와 다르게 움직이는 변수가 아니다!!!!
        int c1y = cPos[0][0];        
        int c2y = cPos[1][0];
        int cx = cPos[0][1]; // 1 개 변수, 주의 cx + 1 아니다!!!!!!!!!!!
        
        // #1 왼쪽 끝
        // 위 ==> 공기 청정기
        for (int y = c1y-1; y > 0; y--) { // 움직이는 방향은 ^, 덮어 쓰는 방향은 v
            map[y][cx] = map[y-1][cx];
        }
        // 아래 ==> 공기 청정기
        for (int y = c2y+1; y < R-1; y++) { // 움직이는 방향은 v, 덮어 쓰는 방향은 ^
            map[y][cx] = map[y+1][cx];
        }
        
        // #2 위쪽 끝, 아래 쪽 끝 (모두 왼쪽으로)
        for (int x = 0; x < C-1; x++) { // 움직이는 방향은 ->, 덮어 쓰는 방향은 <-
            map[0][x] = map[0][x+1]; // 위 쪽 (공기청정기 위)
            map[R-1][x] = map[R-1][x+1]; // 아래 쪽 (공기청정기 아래)
        }
        
        // #3 오른쪽 끝 
        // 아래 ==> 위
        for (int y = 0; y < c1y; y++) { // 움직이는 방향은 v, 덮어 쓰는 방향은 ^
            map[y][C-1] = map[y+1][C-1];
        }
        // 위 ==> 아래
        for (int y = R-1; y > c2y; y--) { // 움직이는 방향은 ^, 덮어 쓰는 방향은 v
            map[y][C-1] = map[y-1][C-1];
        }
        
        // #4 공기청정기 라인
        for (int x = C-1; x > 0; x--) { // 움직이는 방향은 <-, 덮어 쓰는 방향은 ->
            map[c1y][x] = map[c1y][x-1]; // 위 쪽 (공기청정기 위)
            map[c2y][x] = map[c2y][x-1]; // 아래 쪽 (공기청정기 아래)
        }
        
        // 공기청정기 바로 옆은 0으로 !!!!!!
        map[c1y][cx + 1] = 0;
        map[c2y][cx + 1] = 0;
    }
}
