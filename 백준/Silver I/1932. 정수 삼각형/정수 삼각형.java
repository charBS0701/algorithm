import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] tri;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tri = new int[n][];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			tri[i] = new int[i+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 풀이
		for (int i = 0; i < n; i++) {	// 1층 초기화
			dp[n-1][i] = tri[n-1][i];
		}
		for (int i = 1; i < n; i++) {	// dp 진행
			for (int j = 0; j < n-i; j++) {
				dp[n-i-1][j] = Math.max(dp[n-i][j], dp[n-i][j+1]) + tri[n-i-1][j];
			}
		}
		System.out.println(dp[0][0]);
	}

}
