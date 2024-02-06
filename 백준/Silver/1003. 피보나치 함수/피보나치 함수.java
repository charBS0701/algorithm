import java.io.BufferedReader;
import java.io.InputStreamReader;

// fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int result0, result1; // 0과 1이 호출되는 횟수
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 입력
		// 로직
		dp = new int[40+1][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		dp[2][0] = 1;
		dp[2][1] = 1;
		
		for (int n = 3; n <= 40; n++) {
			dp[n][0] = dp[n-1][0] + dp[n-2][0];
			dp[n][1] = dp[n-1][1] + dp[n-2][1];
		}
		
		for (int t = 0; t < T; t++) { // 테스크케이스 수행 // N은 40보다 작거나 같은 자연수 또는 0
			int N = Integer.parseInt(br.readLine());

			result0 = dp[N][0];
			result1 = dp[N][1];

			// 출력
			sb.append(result0).append(" ").append(result1).append("\n");
		}
		System.out.println(sb);

	}

}