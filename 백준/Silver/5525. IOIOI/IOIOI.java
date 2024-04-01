import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N, M, result;
	static String S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());	// 1 ≤ N ≤ 1,000,000
		M = Integer.parseInt(br.readLine());	// 2N+1 ≤ M ≤ 1,000,000
		S = br.readLine();
		
		for (int i = 1; i <= N; i++) {
			if (i==1) sb.append("I").append("O").append("I");
			else sb.append("O").append("I");
		}
		
		// 풀이
		int subSize = sb.length();
		
		for (int i = 0; i <= M-subSize; i++) {
			if (S.substring(i,i+subSize).equals(sb.toString())) result++;
		}
		
		System.out.println(result);
	}
	
}