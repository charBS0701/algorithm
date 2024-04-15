// 1676 팩토리얼 0의 개수
// https://www.acmicpc.net/problem/1676

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {

	static int N;
	static BigInteger res = new BigInteger("1");

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			res = res.multiply(new BigInteger(Integer.toString(i)));
		}
		
		String str = res.toString();
		
		int count = 0;
		for (int i = str.length()-1; i >= 0; i--) {
			if (str.charAt(i) == '0') count++;
			else {
				System.out.println(count);
				return;
			}
		}
	}
}
