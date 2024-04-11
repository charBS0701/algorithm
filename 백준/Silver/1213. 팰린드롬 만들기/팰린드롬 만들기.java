// 1213 팰린드롬 만들기
// https://www.acmicpc.net/problem/1213

import java.io.*;
import java.util.*;

public class Main {
	static String s;
	static boolean failFlag = false;
	static int[] chars = new int[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			chars[c - 'A']++;
		}

		// 홀수인게 2개 이상이면 실패
		int oddCnt = 0;
		int oddIdx = -1;
		for (int i = 0; i < 26; i++) {
			if (chars[i] % 2 == 1) {
				oddCnt++;
				oddIdx = i;
			}
		}
		if (oddCnt >= 2)
			failFlag = true; // 홀수개가 2개 이상이면
		else if (oddCnt == 1 && s.length() % 2 == 0)
			failFlag = true; // 홀수개가 있는데 총길이가 짝수이면
		if (failFlag) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}

		// 팰린드롬 가능
		for (int i = 0; i < 26; i++) {
			int num = chars[i] / 2;
			for (int n = 0; n < num; n++) {
				sb.append((char) (i + 'A'));
			}
		}

		// 뒤쪽 처리
		for (int i = sb.length() - 1; i >= 0; i--) {
			sb.append(sb.charAt(i));
		}

		// 홀수 처리
		if (oddIdx != -1)
			sb.insert(sb.length() / 2, (char) (oddIdx + 'A'));

		System.out.println(sb);

	}
}