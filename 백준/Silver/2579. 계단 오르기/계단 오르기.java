import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 	// 계단의 수
		int[] stairs = new int[N+1];
		
		for (int n=1; n<=N; n++) {	// 계단당 점수 입력
			stairs[n] = sc.nextInt();
		}
		
		if (N==1) {
			System.out.println(stairs[1]);
			return;
		} else if (N==2) {
			System.out.println(stairs[1]+stairs[2]);
			return;
		} else if (N==3) {
			System.out.println(Math.max(stairs[1]+stairs[3], stairs[2]+stairs[3]));
			return;
		}
		
		int[] dp = new int[N+1];	// 각 계단에 올랐을 때 얻을 수 있는 최대 점수
		dp[1] = stairs[1];
		dp[2] = dp[1]+stairs[2];
		// dp3 은 1번째+3번째, 2번째+3번째 중 큰 것
		dp[3] = Math.max( dp[1]+stairs[3] , stairs[2]+stairs[3] );
		
		for (int n=4; n<=N; n++) {
			// dp[n] = (2번째 전dp + 마지막 칸), (3번째 전dp + 1번째 전 + 마지막 칸) 중 큰 것  
			dp[n] = Math.max(dp[n-2]+stairs[n], dp[n-3]+stairs[n-1] + stairs[n]);
		}
		
		System.out.println(dp[N]);
	}
}
