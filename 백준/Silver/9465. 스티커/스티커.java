import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T, n, max; // n (1 ≤ n ≤ 100,000)
	static int[][] sti;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			max = 0;
			n = Integer.parseInt(br.readLine());
			sti = new int[2][n];
			dp = new int[2][n];

			for (int r = 0; r < 2; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < n; c++) {
					sti[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			// 풀이 // 두 변을 공유하지 않는 스티커 점수의 최댓값
			dp[0][0] = sti[0][0];
			dp[1][0] = sti[1][0];
            
            max = Math.max(dp[0][0], dp[1][0]);

			if (n != 1) {
				for (int i = 1; i < n; i++) {
					dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + sti[0][i]);
					dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + sti[1][i]);
					max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
				}
			}

			sb.append(max).append("\n");
		}

		System.out.println(sb);

	}

}
