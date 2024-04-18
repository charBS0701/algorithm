// 17413 단어 뒤집기 2
// https://www.acmicpc.net/problem/17413

import java.io.*;
import java.util.*;

public class Main {
	static String str;		// 10만 이하	
	static Deque<Character> stack = new ArrayDeque<>();
	static boolean inTag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		str = br.readLine();	
		
		for (int i = 0; i <str.length() ; i++) {
			char c = str.charAt(i);
			if (c == '<') {
				while(!stack.isEmpty()) sb.append(stack.pop());
				sb.append('<');
				inTag = true;
			} else if (c == '>') {
				sb.append('>');
				inTag = false;
			} else if (c == ' ') {
				while(!stack.isEmpty()) sb.append(stack.pop());
				sb.append(' ');
			} else {
				if (inTag) sb.append(c);
				else stack.push(c);
			}
		}
		while(!stack.isEmpty()) sb.append(stack.pop());	// 스택에 남은 문자열 처리
		
		System.out.println(sb);
	}
	
	
}