import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] map = new char[10][10];
	static int[] dy = new int[] { 0, 1, -1, 1 }; // 가로, 세로, 우상향, 우하향
	static int[] dx = new int[] { 1, 0, 1, 1 }; // 가로, 세로, 우상향, 우하향

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] != '.')
					continue;
				map[i][j] = 'X';
				// 오목 확인
				for (int r = 0; r < 10; r++) {
					for (int c = 0; c < 10; c++) {
						if (check5(r, c)) {
							System.out.println(1);
							return;
						}
					}
				}
				// 아니면 되돌리기
				map[i][j] = '.';
			}
		}
		System.out.println(0);
	}

	public static boolean check5(int r, int c) {
		// 가로 체크
		int ny = r;
		int nx = c;
		for (int i = 0; i < 5; i++) {
			if (i != 0) {
				ny += dy[0];
				nx += dx[0];
			}
			if (!isValid(ny, nx) || map[ny][nx] != 'X')
				break;
			if (i == 4)
				return true;
		}

		// 세로 체크
		ny = r;
		nx = c;
		for (int i = 0; i < 5; i++) {
			if (i != 0) {
				nx += dx[1];
				ny += dy[1];
			}
			if (!isValid(ny, nx) || map[ny][nx] != 'X')
				break;
			if (i == 4)
				return true;
		}

		// 우상향 체크
		ny = r;
		nx = c;
		for (int i = 0; i < 5; i++) {
			if (i != 0) {
				ny += dy[2];
				nx += dx[2];
			}
			if (!isValid(ny, nx) || map[ny][nx] != 'X')
				break;
			if (i == 4)
				return true;
		}
		// 우하향 체크
		ny = r;
		nx = c;
		for (int i = 0; i < 5; i++) {
			if (i != 0) {
				ny += dy[3];
				nx += dx[3];
			}
			if (!isValid(ny, nx) || map[ny][nx] != 'X')
				break;
			if (i == 4)
				return true;
		}

		return false;
	}

	public static boolean isValid(int r, int c) {
		if (r < 0 || c < 0 || r >= 10 || c >= 10)
			return false;
		return true;
	}

}
