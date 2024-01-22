import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = N;	// 소수의 수 
		for (int n = 0; n < N; n++) {
			int num  = sc.nextInt();
			if (num == 1) {		// 1은 소수가 아니다
				result--;
				continue;
			} else if (num == 2) continue;	// 2는 소수이다
			
			for (int div=2; div<=num/2; div++) {
				if (num%div == 0) {	// 소수가 아니면
					result--;
					break;
				}
			}
		}
		System.out.println(result);

	}

}