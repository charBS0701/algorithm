import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map = new int[20][20];
	static boolean flag;
	static int color5;
	static int[][] map6 = new int[20][20]; // 6목의 원소 체크

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			if (i % 2 == 1) { // 홀수번째 : 흑
				map[y][x] = 1;
			} else { // 짝수번째 : 백
				map[y][x] = 2;
			}

			// 오목판별
			for (int r = 1; r <= 19; r++) {
				for (int c = 1; c <= 19; c++) {
					for (int d = 0; d < 4; d++) {
						check5(1, r, c, 0, d);
						check5(2, r, c, 0, d);
						if (flag) {
							System.out.println(i);
							return;
						}
					}
				}
			}

		}
		System.out.println(-1);
	}

	static void check5(int color, int y, int x, int stack, int d) { // 5목 판별
		if (!isValid(y, x) || map[y][x] != color)
			return;
		if (++stack == 5) { // 5목 찾음
			// 전 칸이 같은색이 아니어야 함
			int prevY = 0, prevX = 0;
			switch (d) {
			case 0:
				prevY = y;
				prevX = x - 5;
				break;
			case 1:
				prevY = y - 5;
				prevX = x;
				break;
			case 2:
				prevY = y - 5;
				prevX = x - 5;
				break;
			case 3:
				prevY = y + 5;
				prevX = x - 5;
				break;
			}
			if (!isValid(prevY, prevX) || map[prevY][prevX] != color) {
				flag = true;
				color5 = color;
			}

		}
		if (stack == 6) { // 6목일 경우
			flag = false;
			return;
		}

		// 가로
		if (d == 0)
			check5(color, y, x + 1, stack, 0);
		// 세로
		else if (d == 1)
			check5(color, y + 1, x, stack, 1);
		// 우하향 대각선
		else if (d == 2)
			check5(color, y + 1, x + 1, stack, 2);
		// 우상향 대각선
		else if (d == 3)
			check5(color, y - 1, x + 1, stack, 3);
	}

	static boolean isValid(int y, int x) { // 범위 보호
		if (y <= 0 || x <= 0 || y >= 20 || x >= 20)
			return false;
		return true;
	}

}
