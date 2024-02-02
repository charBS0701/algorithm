import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 누적합 이용
public class Main {

	static final int MX = 15;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, N, M, v[][], res;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			v = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					v[i][j] = Integer.parseInt(st.nextToken());
					v[i][j] += (v[i - 1][j] + v[i][j - 1] - v[i - 1][j - 1]);
				}
			}
			res = 0;
			for (int i = M; i <= N; i++)	// 2 5
				for (int j = M; j <= N; j++)
					res = Math.max(res, v[i][j] - v[i - M][j] - v[i][j - M] + v[i - M][j - M]);
			System.out.printf("#%d %d\n", t, res);
		}
	}
}
