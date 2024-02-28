import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 최단경로 - bfs
// 말(K번), 원숭이
public class Main {

	static int K, W, H;
	static int[][] map;
	static boolean[][][] visit; // 현재 좌표에서 K 값에 따라 경우의 수가 달라진다.

	// delta : 상하좌우, 원숭이
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int[] hdy = { -2, -2, -1, -1, 2, 2, 1, 1 };
	static int[] hdx = { -1, 1, -2, 2, -1, 1, -2, 2 };

	static Queue<Node> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine()); // 0~30 // 말처럼 움직일 수 있는 횟수
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 1~200
		H = Integer.parseInt(st.nextToken()); // 1~200

		map = new int[H][W];
		visit = new boolean[H][W][K + 1]; // K=3 => 0, 1, 2, 3

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		// 풀이

		bfs(0, 0);

	}

	static void bfs(int y, int x) {
		// 시작좌표 처리
		visit[0][0][K] = true;
		queue.offer(new Node(0, 0, K, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			// 목표 도달 - 출력
			if (node.y == H - 1 && node.x == W - 1) {
				System.out.println(node.d);
				return; // 바로 종료
			}

			// 탐색 - 상하좌우 - K 사용 X
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k])
					continue;

				visit[ny][nx][node.k] = true;
				queue.offer(new Node(ny, nx, node.k, node.d + 1));
			}

			// 탐색 - 말 - 조건에 맞아야 진행 - K 사용
			if (node.k == 0)
				continue;

			for (int i = 0; i < 8; i++) {
				int ny = node.y + hdy[i];
				int nx = node.x + hdx[i];
				if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k - 1])
					continue;

				visit[ny][nx][node.k - 1] = true;
				queue.offer(new Node(ny, nx, node.k - 1, node.d + 1));
			}

		}

		// 출력 -1
		System.out.println(-1);
	}

	static class Node {
		int y, x, k, d; // 좌표, K, 몇번

		public Node(int y, int x, int k, int d) {
			this.y = y;
			this.x = x;
			this.k = k;
			this.d = d;
		}

	}

}
