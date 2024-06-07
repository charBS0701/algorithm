import java.io.*;
import java.util.*;

public class Main {

	static int x;	// 1 ~ 10_000_000
	static int n;	// 분모 분자 합 - 1		// 짝수: 분자가1로 시작, 홀수: 분모가 1로 시작
	static int c; 	// 해당 행의 몇 번째 수인지

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		x = Integer.parseInt(br.readLine());
		
		for (int i=1; ; i++) {
			if (i*(i-1)/2 >= x) {
				n = i-1;
				break;
			}
		}
		
		c = x - (n)*(n-1)/2;
		
		if (n%2==0) {
			sb.append(c).append("/").append(n+1-c);
		} else {
			sb.append(n+1-c).append("/").append(c);
		}
		
		System.out.println(sb);
	}

}
