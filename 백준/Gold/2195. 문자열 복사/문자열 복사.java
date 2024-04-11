// 2195 문자열 복사
// https://www.acmicpc.net/problem/2195

import java.io.*;
import java.util.*;

public class Main {

	static String S, P; // 1<=S,P<=1_000
	static List<Integer> list = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		P = br.readLine();

		// 풀이
		int idx = 0; // 완성된 배열의 인덱스

		while (idx < P.length()) {
			list.clear();
			map.clear();

			for (int i = 0; i < S.length(); i++) { // 시작할 곳 찾기
				if (S.charAt(i) == P.charAt(idx))
					list.add(i);
			}

			int max = 1;
			
			// 그 뒤에 더 이어지는 최대값 찾기
			for (Integer k : list) {
				int tmpK = k;
				int tmpIdx = idx;
				while (tmpK + 1 < S.length() && tmpIdx + 1 < P.length()) {
					if (S.charAt(++tmpK) == P.charAt(++tmpIdx)) {
						max = Math.max(max, tmpK - k + 1);
					} else
						break;
				}
			}

			idx += max;
			result++;
		}

		System.out.println(result);
	}
}
