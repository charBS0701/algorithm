import java.util.Scanner;

public class Main {
	static long A, B, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		C = sc.nextLong();

		System.out.println(pow(A, B));

	}

	static long pow(long a, long b) {
		if (b == 1)
			return a % C;

		long res = pow(a, b / 2);	// devide
		
		res = (res * res) % C;		// merge
		
		if (b % 2 != 0)		// 홀수승일 때는 한 번더 곱해준다
			res = (res * a) % C;
		
		return res;
	}
}
