import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int map[][];
	static Room[] select = new Room[3];
	static List<Room> list = new ArrayList<>();
	static List<Room> virus =  new ArrayList<>();
	static int max = 0;
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) // 벽을 세울 수 있는 방 리스트
					list.add(new Room(i, j));
				if (map[i][j] == 2)
					virus.add(new Room(i, j));
			}
		}

		// 풀이
		comb(0, 0);
		
		System.out.println(max);

	}

	static void bfs(int y, int x) {
		Queue<int[]> que = new ArrayDeque<>();
		visit = new boolean[N + 1][M + 1];
		que.offer(new int[] { y, x });
		visit[y][x] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur[0] + dy[d];
				int nx = cur[1] + dx[d];
				if (ny < 1 || nx < 1 || ny > N || nx > M || visit[ny][nx] || map[ny][nx] != 0)
					continue;
				map[ny][nx] = 4;
				que.offer(new int[] { ny, nx });
				visit[ny][nx] = true;
			}
		}

	}

	static void check() {
		for (int i = 0; i < 3; i++) {
			Room tmp = select[i];
			map[tmp.y][tmp.x] = 3; // 새로운 벽은 3
		}
		// 바이러스 퍼뜨리기
		for (int i = 0; i < virus.size(); i++) {
			Room tmp = virus.get(i);
			bfs(tmp.y, tmp.x);
		}
		// 안전구역 수 세기
		int count = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}
		max = Math.max(max, count);
		// 벽 원상복구		// 바이러스 원상복구
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 3 || map[i][j] == 4)
					map[i][j] = 0;
			}
		}

	}

	static void comb(int tgtIdx, int srcIdx) {
		if (tgtIdx == 3) {
			// complete 코드
			check();
			return;
		}

		if (srcIdx == list.size())
			return;

		select[tgtIdx] = list.get(srcIdx);

		comb(tgtIdx + 1, srcIdx + 1);
		comb(tgtIdx, srcIdx + 1);
	}

	static class Room {
		int y;
		int x;

		Room(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		@Override
		public String toString() {
			return "y : " + y + ", x : " + x;
		}
	}

}
