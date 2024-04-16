// 18007 Rainbow Strings
// https://www.acmicpc.net/problem/18007


import java.io.*;
import java.util.*;

public class Main {
	static String s;
	static int[] list = new int[26];
	static long result=1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			list[s.charAt(i)-'a']++;
		}
		
		for (int i = 0; i < 26; i++) {
			result *= list[i]+1;
			result %= 11092019;
		}
		
		System.out.println(result);
	}
	
}