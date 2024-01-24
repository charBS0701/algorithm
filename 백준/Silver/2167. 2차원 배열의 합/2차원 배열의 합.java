import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] mat = new int[N+1][M+1];
		
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 1; m <= M; m++) {
				mat[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
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