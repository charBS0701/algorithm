// 17136 색종이 붙이기
// https://www.acmicpc.net/problem/17136
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17136_색종이붙이기 {

	static int[][] map = new int[10][10];
	static int[] paperCnt = { 0, 5, 5, 5, 5, 5 };
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = Integer.MAX_VALUE;
		// 풀이 dfs
		dfs(0, 0, 0);

		if (ans == Integer.MAX_VALUE)
			ans = -1;

		System.out.println(ans);

	}

	static void dfs(int y, int x, int cnt) {
		if (y == 9 && x > 9) {
			ans = Math.min(ans, cnt);
			return;
		}

		// 가지치기
		if (ans <= cnt)
			return;

		// 개행
		if (x > 9) {
			y += 1;
			x = 0;
		}

		// 탐색시작
		if (map[y][x] == 1) {

			// 5가지 색종이를 모두 고려, 남은 색종이 수도 함께
			// 1인 칸에 색종이를 무조건 사용
			for (int i = 1; i <= 5; i++) {
				// 색종이가 남아있고, 색종이를 붙일 수 있는지 (canAttach())
				if (paperCnt[i] > 0 && canAttach(y, x, i)) {
					// 색종이 붙이기
					// 색종이 cnt--
					attach(y, x, i, 0);
					paperCnt[i]--;

					// 재귀호출
					dfs(y, x + i - 1, cnt + 1);

					// 색종이 떼기
					// 색종이 cnt++
					attach(y, x, i, 1);
					paperCnt[i]++;
				}
			}
		} else {
			dfs(y, x + 1, cnt);
		}
	}

	static boolean attach(int y, int x, int size, int num) {
		// 모두 1인지
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				map[i][j] = num;
			}
		}

		return true;
	}

	static boolean canAttach(int y, int x, int size) {
		// size 색종이를 붙이기에 10*10 을 벗어나는지 확인
		if (y + size > 10 || x + size > 10)
			return false;

		// 모두 1인지
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}

		return true;
	}
}
