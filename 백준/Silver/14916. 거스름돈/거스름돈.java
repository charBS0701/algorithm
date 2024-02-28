import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[100_001];
		Arrays.fill(dp, -1);

		dp[2] = 1;
		dp[4] = 2;
		dp[5] = 1;

		if (n > 5) {
			for (int i = 6; i <= n; i++) {
				int tmp = Integer.MAX_VALUE;

				if (dp[i - 2] != -1) {
					tmp = Math.min(dp[i - 2] + 1, tmp);
				}
				if (dp[i - 5] != -1) {
					tmp = Math.min(dp[i - 5] + 1, tmp);
				}
				if (tmp != Integer.MAX_VALUE)
					dp[i] = tmp;
			}
		}

		System.out.println(dp[n]);

		sc.close();
	}
}
