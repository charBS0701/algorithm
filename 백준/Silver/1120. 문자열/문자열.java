import java.io.*;
import java.util.*;

public class Main {

	static String A, B;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = st.nextToken();
		B = st.nextToken();
		int lenA = A.length();
		int lenB = B.length();
		for (int i = 0; i <= lenB - lenA; i++) {
			int cnt = 0;
			for (int j = 0; j < lenA; j++) {
				if (A.charAt(j) != B.charAt(i+j)) cnt++;
			}
			min = Math.min(min, cnt);
			
			if (min == 0) break;
		}
		
		System.out.println(min);
	}
}