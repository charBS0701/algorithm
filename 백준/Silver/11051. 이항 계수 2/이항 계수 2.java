import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 1~1000
		int K = Integer.parseInt(st.nextToken()); // 0~N

		// nCk % 10,007 출력

		dp = new int[N + 1][K + 1];

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				if (i == j || j == 0) {
					dp[i][j] = 1;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
			}
		}
		
		System.out.println(dp[N][K]);

	}

}
