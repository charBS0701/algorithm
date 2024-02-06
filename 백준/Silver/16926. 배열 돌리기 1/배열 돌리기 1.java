import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, R;
	static int[][] mat;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 2 ≤ N, M ≤ 300
		M = Integer.parseInt(st.nextToken()); // min(N, M) mod 2 = 0 // 적어도 하나는 짝수
		R = Integer.parseInt(st.nextToken()); // 회전 횟수 // 1 ≤ R ≤ 1,000

		mat = new int[N][M];
		for (int i = 0; i < N; i++) { // 배열 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 풀이
		for (int r = 0; r < R; r++) {
			rotate();
		}
		
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(mat[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void rotate() { // 1회 회전
		int sy = 0, ey = N - 1; // 회전 시작 y, 종료 y
		int sx = 0, ex = M - 1; // 회전 시작 x, 종료 x

		while (true) {
			// 종료 조건
			if (ey - sy < 1 || ex - sx < 1)
				return;

			// 복사
			int temp = mat[sy][sx];
			// top <- <-
			for (int i = sx; i < ex; i++) {
				mat[sy][i] = mat[sy][i + 1];
			}
			// right ^
			for (int i = sy; i < ey; i++) {
				mat[i][ex] = mat[i + 1][ex];
			}
			// bottom -> ->
			for (int i = ex; i > sx; i--) {
				mat[ey][i] = mat[ey][i - 1];
			}
			// left v
			for (int i = ey; i > sy; i--) {
				mat[i][sx] = mat[i - 1][sx];
			}

			mat[sy + 1][sx] = temp;

			// sy, sx, ey, ex 안쪽으로 1칸 보정
			sy++;
			sx++;
			ey--;
			ex--;
		}

	}
}
