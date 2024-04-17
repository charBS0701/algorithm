// 9461 파도반 수열
// https://www.acmicpc.net/problem/9461

import java.io.*;
import java.util.*;

public class Main {
	static int T, N; // 1 <= N <= 1000
	static long[] memoi = new long[101];;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		memoi[1] = 1;
		memoi[2] = 1;
		memoi[3] = 1;
		memoi[4] = 2;
		memoi[5] = 2;

		for (int i = 6; i <= 100; i++) {
			memoi[i] = memoi[i-1] + memoi[i-5];
		}

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			sb.append(memoi[N]).append("\n");
		}

		System.out.println(sb);

	}

}