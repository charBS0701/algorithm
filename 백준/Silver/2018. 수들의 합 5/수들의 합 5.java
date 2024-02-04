import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int count = 1;

	public static void main(String[] args) {
		N = sc.nextInt();

		for (int i = 1; i < N; i++) {
			int sum = i;
			for (int j = i + 1; j < N; j++) {
				sum += j;
				if (sum == N) {
					count++;
					break;
				} else if (sum > N)
					break;
			}
		}

		System.out.println(count);
	}

}
