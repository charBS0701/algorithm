import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 666;; i++) {
			String s = String.valueOf(i);
			int stack=0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j)=='6') stack++;
				else stack = 0;
				if (stack==3) {
					cnt++;
					break;
				}
			}

			if (cnt == N) {
				System.out.println(i);
				break;
			}
		}

		sc.close();
	}

}