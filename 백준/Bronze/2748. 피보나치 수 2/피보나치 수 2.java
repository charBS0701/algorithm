import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static long[] dp;
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new long[n+1];
		for (int i = 1; i < n+1; i++) {
			dp[i] = -1;
		}
		dp[0] = 0;
		dp[1] = 1;
		System.out.println(fibo(n));
	}
	
	public static long fibo(int n) {
		if (dp[n]!= -1) return dp[n];
		else return dp[n] = fibo(n-1) + fibo(n-2);
	}

}
