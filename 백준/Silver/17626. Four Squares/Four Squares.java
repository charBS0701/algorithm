// 17626 Four Squares
// https://www.acmicpc.net/problem/17626

import java.io.*;
import java.util.*;

public class Main {
	static int N; // 1~50_000
	static int[] pow;
	static int result=4;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int len = (int)Math.sqrt(N);
		pow = new int[len+1];
		
		for (int i = 1; i < pow.length; i++)
			pow[i] = i * i;

		// 풀이
		for (int i = len; i >= 1; i--) {
			int tmp = N;
			tmp -= (int) Math.pow(i, 2);
			if (tmp == 0) {
				result = 1;
				break;
			}
			for (int j = (int) Math.sqrt(tmp); j >= 1; j--) {
				int tmp2 = tmp;
				tmp2 -= (int) Math.pow(j, 2);
				if (tmp2 == 0) {
					result = Math.min(result, 2);
					break;
				}
				for (int k = (int) Math.sqrt(tmp2) ; k >= 1; k--) {
					int tmp3 = tmp2;
					tmp3 -= (int) Math.pow(k, 2);
					if (tmp3 == 0) {
						result = Math.min(result, 3);
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
}
