// 1747 소수&팰린드롬
// https://www.acmicpc.net/problem/1747

import java.io.*;
import java.util.*;

public class Main {

	static int N; // (1 ≤ N ≤ 1,000,000)
	static int MAX = 1_004_000;
	static boolean[] isPrime = new boolean[MAX+1];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 1~1_000_000 소수 여부
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i <= Math.sqrt(MAX); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < MAX; j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		for (int i = N; i <= MAX; i++) {
			if(!isPrime[i]) continue;
			// 팰린드롬 확인
			if(isPal(i)) {
				System.out.println(i);
				return;
			}
		}

	}
	
	static boolean isPal(int num) {
		String tmp = Integer.toString(num);
		for (int j = 0; j < tmp.length()/2; j++) {
			if (tmp.charAt(j) != tmp.charAt(tmp.length()-1-j)) return false;
		}
		return true;
	}
}