import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] cost;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N + 1][3];
		dp = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken()); // R
			cost[i][1] = Integer.parseInt(st.nextToken()); // G
			cost[i][2] = Integer.parseInt(st.nextToken()); // B
		}
		
		for (int i = 1; i <= N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + cost[i][2];
		}

		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));

	}

}