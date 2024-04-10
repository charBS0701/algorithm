// 1254 팰린드롬 만들기
// https://www.acmicpc.net/problem/1254

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String s;	// 길이 50
	static int tmp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		int len = s.length();
		tmp = len-1;
		
		// 뒤에서부터 부분문자열의 팰린드롬을 찾는다
		for (int i = len-1; i >= 0; i--) {
			if (isPal(i)) tmp = i;
		}
		
		System.out.println(len+tmp);
		
	}
	
	static boolean isPal(int from) {
		int len = s.length()-from;
		for (int i = 0; i < len; i++) {
			if (s.charAt(from+i) != s.charAt(s.length()-1-i)) return false;
		}
		return true;
	}
	
}