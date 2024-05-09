import java.io.*;
import java.util.*;

public class Main {
	static int N, X, S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());		
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			if (c <= X && p > S) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
		
	}
}
