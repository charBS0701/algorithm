// 시뮬레이션 + bfs ( 몇시간 걸리는지..)
// 반복
// 1. 공기를 모두 탐색하면서 공기 주변의 치즈를 발견하면 치즈의 자료구조에 담는다.
// 2. 치즈의 자료구조를 모두 돌면서 공기로 바꾸고 그걸 다시 공기의 자료구조에 담는다.
// 위 1회 반복이 1시간

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H, W, hour, cheese; // 치즈는 매번 새로 계산
	static int[][] map;
	static boolean[][] visitAir, visitCheese; // visitAir : 공기끼리 방문하면서 중복 체크, visitCheese : 치즈 중복 발견 X
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 };

	static Queue<Node> queueAir = new ArrayDeque<>();
	static Queue<Node> queueBorder = new ArrayDeque<>(); // ArrayList 상관없음

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visitAir = new boolean[H][W];
		visitCheese = new boolean[H][W];

		for (int i = 0; i < H; i++) { // map 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 풀이
		// 0,0 에서 공기를 계속 탐색해 가면서 치즈를 만나면 치즈 자료구조에 담고. 공기전환..
		visitAir[0][0] = true;
		queueAir.offer(new Node(0, 0));

		// 시뮬레이션 반복
		while (true) {
			bfsAir();
			if (queueBorder.isEmpty())
				break;
			bfsBorder();

			hour++;
		}

		System.out.println(hour);
		System.out.println(cheese);
	}

	static void bfsAir() {
		while (!queueAir.isEmpty()) {
			Node n = queueAir.poll();

			for (int d = 0; d < 4; d++) {
				int ny = n.y + dy[d];
				int nx = n.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= H || nx >= W || visitAir[ny][nx])
					continue;

				// 공기, 치즈에 따라 각각 처리
				if (map[ny][nx] == 0) { // 공기
					visitAir[ny][nx] = true;
					queueAir.offer(new Node(ny, nx));
				} else if (map[ny][nx] == 1) { // 치즈 (공기와 맞닿은 치즈)
					if (visitCheese[ny][nx])
						continue;
					visitCheese[ny][nx] = true;
					queueBorder.offer(new Node(ny, nx));
				}
			}
		}
	}

	static void bfsBorder() { // 경계선의 치즈 -> 공기, 남은 치즈 계산
		cheese = 0; // 마지막 남은 치즈를 항상 초기화

		while (!queueBorder.isEmpty()) {
			Node n = queueBorder.poll();
			visitAir[n.y][n.x] = true;
			queueAir.offer(n);
			cheese++;
		}

	}

	static class Node { // 좌표
		int y;
		int x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
