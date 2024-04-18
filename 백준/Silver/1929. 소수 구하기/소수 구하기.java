// 1747 소수&팰린드롬
// https://www.acmicpc.net/problem/1747

import java.io.*;
import java.util.*;

public class Main {

	static int M, N; // (1 ≤ N ≤ 1,000,000)
	static int MAX = 1_000_000;
	static boolean[] isPrime = new boolean[MAX+1];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// 1~1_000_000 소수 여부
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i <= Math.sqrt(MAX); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= MAX; j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		for (int i = M; i <= N; i++) {
			if (isPrime[i]) sb.append(i).append("\n");
		}
		
		System.out.println(sb);
		
	}
}