import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N
		
		int[] dp = new int[N+1];
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1]+1;
			if (i%2==0) 
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			if (i%3==0)
				dp[i] = Math.min(dp[i], dp[i/3]+1);
		}
		System.out.println(dp[N]);
	}
}