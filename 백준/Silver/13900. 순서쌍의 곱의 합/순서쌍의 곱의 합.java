import java.util.Scanner;

// ab + ac + ad + bc + bd + ca = (a)*b + (a+b)*c + (a+b+c)*d 라는 규칙을 찾음
public class Main {
	static long[] nums;
	static long[] dp;
	static long result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		nums = new long[N + 1];
		dp = new long[N + 1];
		
		for (int i = 1; i <= N; i++) {	// 초기화
			nums[i] = sc.nextInt();
			dp[i] = dp[i - 1] + nums[i];
		}
		for (int i = 2; i <= N; i++) {	// 계산
			result += nums[i] * dp[i - 1];
		}

		System.out.println(result);
	}
}