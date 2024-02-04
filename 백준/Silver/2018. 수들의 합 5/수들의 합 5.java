import java.util.Scanner;
// two pointers
public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int count = 1;
	static int start_index =1;
	static int end_index=1;
	static int sum = 1;

	public static void main(String[] args) {
		N = sc.nextInt();

		while (end_index != N) {
			if (sum == N) {	// 현재 연속 합이 N과 같은 경우
				count++;
				end_index++;
				sum = sum + end_index;
			} else if (sum>N) {	// 현재 연속 합이 N보다 더 큰 경우
				sum = sum - start_index;
				start_index++;
			} else {	// 현재 연속 합이 N보다 작은 경우
				end_index++;
				sum = sum + end_index;
			}
		}
		
		System.out.println(count);
	}
}