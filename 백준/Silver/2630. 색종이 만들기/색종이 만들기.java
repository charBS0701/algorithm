import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] mat;
	static int w, b;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N은 2, 4, 8, 16, 32, 64, 128 중 하나
		mat = new int[N][N];
		for (int i = 0; i < N; i++) { // 색종이 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0, N);

		sb.append(w).append("\n").append(b);
		System.out.println(sb);

	}

	public static void solve(int x, int y, int n) {
		boolean isW = true;
		boolean isB = true;
		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if (mat[i][j] == 0)
					isB = false; // 하나라도 0이 있으면 파란색종이 아님
				if (mat[i][j] == 1)
					isW = false; // 하나라도 1이 있으면 흰종이 아님
				if (isB == false && isW == false) {
					break;
				}
			}
			if (isB == false && isW == false) {
				break;
			}
		}

		if (isW) {
			w++;
			return;
		} else if (isB) {
			b++;
			return;
		}

		solve(x, y, n / 2); // 왼쪽 위
		solve(x + n / 2, y, n / 2); // 오른쪽 위 
		solve(x, y + n / 2, n / 2); // 왼쪽 아래
		solve(x + n / 2, y + n / 2, n / 2); // 오른쪽 아래
	}

}