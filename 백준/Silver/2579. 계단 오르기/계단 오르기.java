// 2579 계단 오르기
// https://www.acmicpc.net/problem/2579

import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] stairs;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stairs = new int[N+1];
		dp = new int[N+1];
		
		for (int n = 1; n <= N; n++) {
			stairs[n] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = stairs[1];
		if(N == 1) {
			System.out.println(dp[1]);
			return;
		}
		dp[2] = dp[1] + stairs[2];
		if(N == 2) {
			System.out.println(dp[2]);
			return;
		}
		
		dp[3] = Math.max(dp[1] + stairs[3], dp[0] + stairs[2] + stairs[3]); 
		
		for (int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
		}
		
		
		System.out.println(dp[N]);
		
	}
}
