import java.io.*;
import java.util.*;

public class Main { 
	static int N;
	static int[] arr;
	static int[] oper = new int[4];	// 덧셈,뺼셈,곱셈,나눗셈
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		// 풀이
		solve(0, arr[0], oper[0], oper[1], oper[2], oper[3]);
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}
	
	static void solve(int idx, int sum, int add, int sub, int mul, int div) {
		if (idx == N-1) {
			max = max < sum ? sum : max;
			min = min > sum ? sum : min;
			return;
		}
		
		if (add>0) solve(idx+1, sum+arr[idx+1], add-1, sub, mul, div);
		if (sub>0) solve(idx+1, sum-arr[idx+1], add, sub-1, mul, div);
		if (mul>0) solve(idx+1, sum*arr[idx+1], add ,sub, mul-1, div);
		if (div>0) solve(idx+1, sum/arr[idx+1], add, sub, mul, div-1);
		
	}
	
}