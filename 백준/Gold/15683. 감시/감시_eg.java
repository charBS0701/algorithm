import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 주어진 카메라 각각에 대해서 모든 가능한 경우를 완탐하는 형태
// 1 카메라 모든 경우 x 2 카메라 모든 경우 x 3 ....N 개 카메라 모든 경우 <= dfs
// 회전 등 모함하는 모든 경우의 감시 => map 에 표시 => 완탐의 과정에서 map 변화 생긴다.
// 1) 신규 map 생성하면서 완탐 -> 조금 쉬운 방법 ( 자원을 많이 사용 ) <= map 이 적절한 크기인지 확인
// 2) map 변경  - 탐색 - 변경 원복 -> 조금 어려운 방법( 자원을 적게 사용 )
public class Main {

	static int N, M, min;
	static int[][] map;
	static List<Cam> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n >= 1 && n <= 5) {
					list.add(new Cam(i, j, n));
				}
			}
		}

		// 풀이
		min = Integer.MAX_VALUE;
		dfs(0, map); // 맨 앞 Cam, 최초 입력 map
		System.out.println(min);
	}

	// idx : list 에 담긴 cam 객체 index
	// parent : 현재 idx 번째 cam 에서 따지기 직전 상태 배열이 복사되어 전달
	static void dfs(int idx, int[][] parent) {
		// 기저조건
		// 감시카메라가 비치지 않은 좌표 계산 min 갱신, return
		if (idx == list.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (parent[i][j] == 0)
						cnt++;
				}
			}
			min = Math.min(min, cnt);
			return;
		}

		// idx 번 cam 으로 탐색
		Cam c = list.get(idx);

		switch (c.n) {
		case 1: // 상,하,좌,우 각각 한 방향으로만 감시
			for (int d = 0; d < 4; d++) {
				int[][] child = copyMap(parent);
				// 비추는 작업
				watch(c.y, c.x, d, child);
				dfs(idx + 1, child);
			}
			break;
		case 2: // 상하, 좌우 감시
			for (int d = 0; d < 2; d++) {
				int[][] child = copyMap(parent);
				// 비추는 작업
				watch(c.y, c.x, d, child);
				watch(c.y, c.x, d + 2, child);
				dfs(idx + 1, child);
			}
			break;
		case 3: // L 형 감시
			for (int d = 0; d < 4; d++) {
				int[][] child = copyMap(parent);
				// 비추는 작업
				watch(c.y, c.x, d, child);
				watch(c.y, c.x, (d + 1) % 4, child);
				dfs(idx + 1, child);
			}
			break;
		case 4: // ㅗ 형 감시
			for (int d = 0; d < 4; d++) {
				int[][] child = copyMap(parent);
				// 비추는 작업
				watch(c.y, c.x, d, child);
				watch(c.y, c.x, (d + 1) % 4, child);
				watch(c.y, c.x, (d + 2) % 4, child);
				dfs(idx + 1, child);
			}
			break;
		case 5: // 상하좌우 동시에
			int[][] child = copyMap(parent);
			// 비추는 작업
			watch(c.y, c.x, 0, child);
			watch(c.y, c.x, 1, child);
			watch(c.y, c.x, 2, child);
			watch(c.y, c.x, 3, child);
			dfs(idx + 1, child);
			break;
		}
	}

	// 주어진 좌표에서부터 dir 방향으로 비추는 작업( 9로 덮어쓰는)
	// 6 만나면 멈춤.
	static void watch(int y, int x, int dir, int[][] array) {
		// dir : 0(좌) 1(상) 2(우) 3(하)
		switch (dir) {
		case 0: // 좌
			for (int i = x; i >= 0; i--) {
				if (array[y][i] == 6)
					break;
				array[y][i] = 9;
			}
			break;
		case 1: // 상
			for (int i = y; i >= 0; i--) {
				if (array[i][x] == 6)
					break;
				array[i][x] = 9;
			}
			break;
		case 2: // 우
			for (int i = x; i < M; i++) {
				if (array[y][i] == 6)
					break;
				array[y][i] = 9;
			}
			break;
		case 3: // 하
			for (int i = y; i < N; i++) {
				if (array[i][x] == 6)
					break;
				array[i][x] = 9;
			}
			break;
		}
	}

	static int[][] copyMap(int[][] origin) {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}

	static class Cam {
		int y, x, n;

		Cam(int y, int x, int n) {
			this.y = y;
			this.x = x;
			this.n = n;
		}
	}
}
