package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기_topDown {

	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		dp = new int[30][30];

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sb.append(comb(M,N)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int comb(int m, int n) {
		if (dp[m][n] != 0) return dp[m][n];
		if (m==n || n==0) return dp[m][n] = 1;
		else return dp[m][n] = comb(m-1,n-1) + comb(m-1,n);
	}

}
