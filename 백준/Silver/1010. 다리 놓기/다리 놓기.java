import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 조합을 계산하는 함수
	public static long combination(int n, int r) {
		// 0 또는 1인 경우는 바로 반환
		if (r == 0 || n == r) {
			return 1;
		}

		// 파스칼의 삼각형을 이용하여 조합 계산
		long[][] dp = new long[n + 1][r + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i && j <= r; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		return dp[n][r];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // N, M (0 < N ≤ M < 30)
			int M = Integer.parseInt(st.nextToken());
			long result = combination(M, N); // 수정된 조합 함수 호출
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}