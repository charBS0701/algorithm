import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//  N(1 ≤ N ≤ 1,000,000,000)
		int max = 1;	// 해당 껍질에 속하는 최대 숫자
		int count=1;	
		int d=1;		// 몇 번째 껍질인지
		
		while (true) {
			if (count==N) {
				System.out.println(d);
				break;
			}
			if (count==max) {
				max += 6 * (d++);
			}
			count++;
		}
		
	}
}
