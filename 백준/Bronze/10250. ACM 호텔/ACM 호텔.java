import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	// 테스트케이스 수
		
		for (int t = 0; t < T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			
			int row = N%H;
			if (N%H == 0) row = H;
			
			int col = N/H+1;
			if (N%H == 0) col = N/H;
			
			
			if (col >= 10) {
				System.out.println(String.valueOf(row) + String.valueOf(col));
			} else {
				System.out.println(String.valueOf(row) + "0" + String.valueOf(col));
			}
			
		}
	}	
}