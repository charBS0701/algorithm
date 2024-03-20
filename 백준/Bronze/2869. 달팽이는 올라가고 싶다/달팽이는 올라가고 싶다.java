import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt(); // (1 ≤ B < A ≤ V ≤ 1,000,000,000)

		int oneDay = A - B;
		int oneDayBefore = V - A;
		int count = oneDayBefore % oneDay == 0 ? oneDayBefore / oneDay : oneDayBefore / oneDay + 1;
		System.out.println(++count);
		
		sc.close();
	}
}