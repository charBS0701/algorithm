package basic;

import java.util.Arrays;
import java.util.Scanner;

// dp <= 간결 (코드 실수 X), 속도 보장
// memoization (기록, 재사용)
// 점화식 등 i -> i + 1.....i-1, i-2 --> i... 이전 단계의 해(답)가 다음 단계의 답을 규정 

public class 설탕배달_eg3 {
	
	static int N;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// 초기 보정
		if (N <= 5) {
			if( N==3 || N==5) System.out.println(1);
			else System.out.println(-1);
			sc.close();
			return;
		}
		
		// 자료구조
		dp = new int[N+1];	// N kg 을 만들 때 필요한 최소 봉투 수 
		Arrays.fill(dp, 5000);
		
		// dp 초기값 설정
		dp[3] = 1;
		dp[5] = 1;
		
		// 점화식 적용
		for (int i = 6; i <= N; i++) {
			dp[i] = Math.min(dp[i-3] + 1, dp[i-5] + 1);
		}
		
		if(dp[N] > 5000 ) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}
		sc.close();
	}
}

