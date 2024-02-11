package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기_topdown {

	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		dp = new int[30][30];

		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				if (i == j || j == 0)
					dp[i][j] = 1;
			}
		}
		
		for (int i = 2; i < 30; i++) {
			for (int j = 1; j < i; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sb.append(dp[M][N]).append("\n");
		}
		System.out.println(sb);
	}

}
