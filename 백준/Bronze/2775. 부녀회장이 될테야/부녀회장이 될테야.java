import java.util.*;
import java.io.*;

public class Main {

	static int T, k, n;
	static int[][] apt = new int[15][15];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int j = 1; j <= 14; j++) {		// 0층 초기화
			apt[0][j] = j;
		}
		
		for (int i = 1; i <= 14; i++) {
			int sum = 0;
			for (int j = 1; j <= 14; j++) {
				sum += apt[i-1][j];
				apt[i][j] = sum;
			}
		}
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			sb.append(apt[k][n]).append("\n");
			
		}
		
		System.out.println(sb);
	}
}