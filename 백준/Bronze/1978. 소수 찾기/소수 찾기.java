import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 입력 갯수 // 100 이하
		
		boolean[] isPrime = new boolean[1001];	// 소수 여부 
		int result = 0;		// 소수 개수
		
		// 소수 배열 업데이트
		for (int i = 0; i <= 1000; i++) {
			isPrime[i] = true;	// 일단 소수로
		}
		isPrime[1] = false;		// 1은 소수아님
		
		for (int i = 2; i*i <= 1000; i++) {
			for (int j = i+i; j <= 1000; j+=i) {
				isPrime[j] = false;
			}
		}
				
		
		for (int i = 0; i < N; i++) {	// 입력받은 수 중 소수 개수 세기
			int num = sc.nextInt();
			if (isPrime[num] == true) result++;
		}
		
		System.out.println(result);
	}
}
