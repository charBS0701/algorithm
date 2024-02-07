import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 1,000보다 작거나 같은 자연수 N
		int dp[] = new int[1001];

		for (int i = 1; i < 100; i++) { // 100 미만은 모두 한수
			dp[i] = i;
		}

		for (int i = 100; i <= 1000; i++) {
			int num = i;			
			int pre = num % 10;		
			num /= 10;				
			int cur = num % 10;		
			int d = pre - cur;	 // 공차	

			int flag = 1;

			while (true) { 
				pre = cur;	
				num /= 10;	
				cur = num % 10;	
				if (pre - num != d) {
					flag = 0;
					break;
				}
				if (num/10 == 0) break;
			}

			dp[i] = dp[i - 1] + flag;

		}

		System.out.println(dp[N]);
	}

}
