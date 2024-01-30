import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 배달해야하는 설탕 N킬로 (3 ≤ N ≤ 5000)
		
		// 5 * a + 3 * b = N 이면 가능, or -1 
		for (int i = 0; i <= 2000; i++) {
			for (int j = 0; j <= 1000; j++) {
				if ( N == 3*i + 5*j) {
					System.out.println(i+j);
					return;
				}
			}
			
		}
		System.out.println(-1);
		return;
	}
}
