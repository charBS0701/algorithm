import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] mat = new int[N+1][M+1];
		
		for (int n = 1; n <= N; n++) {
			for (int m = 1; m <= M; m++) {
				mat[n][m] = sc.nextInt();
			}
		}
		
		int K = sc.nextInt();
		for (int k = 0; k < K; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int fromR = Math.min(i, x);
			int toR = Math.max(i,x);
			int fromC = Math.min(j, y);
			int toC = Math.max(j, y);
			
			int sum=0;
			for (int r=fromR; r<=toR; r++) {
				for (int c=fromC; c<=toC; c++) {
					sum += mat[r][c];
				}
			}
			
			
			System.out.println(sum);
		}
	}
}
