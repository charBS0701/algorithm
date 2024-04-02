import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

1 ~ 9 : 1 + 2 + 3 + ... + 8 + 9
8 ~ 13 : 8 + 9 + 1 + 0 + 1 + 1 + 1 + 2 + 1 + 3

덧셈 문제 ~~> 나눗셈 + 나머지 + 곱셈 

10 ~ 19 = (1 + 0) + (1 + 1) + (1 + 2) ... . + (1 + 8) + (1 + 9)
	<= 1 이 10 개, 1 + 2 + 3 ... + 8 + 9 : 45  => 10 + 45 => 55
	
10 ~ 39 = (1 + 0) + (1 + 1) + (1 + 2) ... . + (1 + 8) + (1 + 9)
		  (2 + 0) + (2 + 1) + (2 + 2) ... . + (2 + 8) + (2 + 9)
		  (3 + 0) + (3 + 1) + (3 + 2) ... . + (3 + 8) + (3 + 9)
	<= 1 이 10 개, 2 가 10개, 3 이 10개, 1 + 2 + 3 ... 8 + 9 : 45 가 3개 
	<= 10//10 => 1, 39//10 => 3 <= (3 - 1 + 1) x 45, (1 + 2 + 3) x 10
	
최초 100 ~ 399 에서 10으로 한 번 나눈 후 상태 (이과정에서 사라진 부분 = (39 - 10 + 1) * 45 = 1350
10 ~ 39 = (1 + 0) + (1 + 1) + (1 + 2) ... . + (1 + 8) + (1 + 9)
		  (2 + 0) + (2 + 1) + (2 + 2) ... . + (2 + 8) + (2 + 9)
		  (3 + 0) + (3 + 1) + (3 + 2) ... . + (3 + 8) + (3 + 9)
		두 수 10, 39 를 10으로 나눈 몫을 남기면 1 ~ 3(1: 100개, 2: 100개, 3: 100개)
		100으로 나누었으므로 사라진 분 : (3 -1 +1) * 45 * 10
	            
1차 정리( x0 ~ x9 )
   주어진 시작수, 종료수에 대해서 10으로 나누고 이 때 사라지는 1의 자리 수에 대한 계산 (x45)
   남는 수에 대해 10자리 처리
   또
   주어진 시작수, 종료수에 대해서 10으로 나누고 이 때 사라지는 1의 자리 수에 대한 계산 (x45)x10
   남는 수에 대 10자리 처리(x10)

찌꺼기
 13 ~ 37 일 때, 13 점점 증가해서 뒷 수가 0이 될 떄까지 홀로 계산, 37 점점 감소하면서 뒷 수가 9될 때까지 홀로 게산 
 
 */
public class Solution {

	static int T;
	static long A, B, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			
			ans = 0;
			long pos = 1;
			
			while ( A <= B ) {	// 최초 시작, 중간 10으로 나눈 뒤
				// 디버깅 코드
//				System.out.printf("%d %d\n", A, B);
				// X9 ~ Y0 포맷이 아닌 경우 찌꺼기 처리
				// from 찌꺼기 
				// 맨 뒷자리가 0이 될 때까지 증가해 간다.
				while( A % 10 != 0 && A <= B) {
					// A 수 처리
					calc(A, pos);
					A++;
				}
				
				if (A > B || A == 0 && B == 0 ) break;
				
				// to 찌꺼기
				// 맨 뒷자리가 9가 될 때까지 감소해 간다.
				while( B % 10 != 9 && A <= B ) {
					// B 수처리
					calc(B, pos);
					B--;
				}
					
				// 두 수를 10으로 나누고 필요한 계산
				A /= 10;
				B /= 10;
				
				long m = ( B - A + 1 ) * pos;	// pos 는 나눈 횟수 최초 1
				ans += 45*m;
				
				pos *= 10;
				
			}
			System.out.println("#" + t + " " + ans);
			
		}
		
	}
	
	static void calc(long n, long t) {
		while( n > 0 ) {
			ans += (n % 10) * t;
			n /= 10;
		}
	}
	
	static long calcDebug(long n, long t) {
		long sum = 0;
		while ( n > 0 ) {
			long num = (n % 10) * t;
//			System.out.println(num);
			sum += num;
			n /= 10;
		}
		return sum;
	}
}
