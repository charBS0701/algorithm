// 시간초과 실패

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int M, N; // 2 ≤ M,N ≤ 1,000
	static int[][] map; // -1 : 토마토 없음, 0 : 안익음, 1 : 익음
	static int[][] nextMap;
	static int day, flag;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		nextMap = new int[N][M];
		for (int i = 0; i < N; i++) { // 토마토 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) // 다음날 익은 토마토 저장할 map 깊은 복사
			nextMap[i] = map[i].clone();

		// 풀이
		if (check()) { // 처음부터 다 익어있음
			System.out.println(0);
			return;
		}
		while (true) {
			// 하루동안 토마토가 익는 과정
			day++;
			flag=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 1)
						continue; // 익은 토마토가 있는 칸이 아니면 continue
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if (ny < 0 || nx < 0 || ny >= N || nx >= M) // map 벗어난 경우
							continue;
						if (map[ny][nx] == 0) { // 안익은 토마토가 있는 칸이면
							nextMap[ny][nx] = 1; // 익음
							flag=1;	// 토마토 변화가 있다는 것 처리
						}
					}
				}
			}

			// 하루가 지나도 변화가 없으면 다 못익는 경우
			if (flag==0) {
				System.out.println(-1);
				return;
			}

			// 익은 토마토 상태 업데이트
			for (int i = 0; i < N; i++) // 다음날 익은 토마토 저장할 map 깊은 복사
				map[i] = nextMap[i].clone();

			if (check()) { // 토마토가 다 익으면
				System.out.println(day);
				return;
			}
		}
	}

	static boolean check() { // 토마토 다 익었는지
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}
		return true;
	}

}
