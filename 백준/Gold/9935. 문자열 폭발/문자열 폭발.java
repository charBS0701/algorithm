import java.io.*;
import java.util.*;

public class Main {
	static String S;
	static String bomb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		bomb = br.readLine();
		int len = bomb.length();
		
		StringBuilder sb = new StringBuilder();
		for (char c : S.toCharArray()) {
			sb.append(c);
			if (sb.length() >= len) {
				if (sb.substring(sb.length()-len).equals(bomb)) {
					sb.setLength(sb.length()-len);
				}
			}
		}
		
		if (sb.length()==0) System.out.println("FRULA");
		else System.out.println(sb.toString());
	}
}