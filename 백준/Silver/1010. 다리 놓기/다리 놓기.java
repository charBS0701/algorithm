import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int N,M;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		dp = new int[30][30];
		
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j <= i; j++) {
				if (j==0 || i==j) dp[i][j] = 1;
				else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sb.append(dp[M][N]).append("\n");
		}
		System.out.println(sb);
	}
}
