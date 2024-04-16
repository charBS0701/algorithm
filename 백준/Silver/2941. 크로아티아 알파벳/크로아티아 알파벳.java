// 2941 크로아티아 알파벳
// https://www.acmicpc.net/problem/2941

import java.io.*;
import java.util.*;

public class Main {

	static char[] input;
	static int result;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		int len = input.length;
		set.add("c=");
		set.add("c-");
		set.add("dz=");
		set.add("d-");
		set.add("lj");
		set.add("nj");
		set.add("s=");
		set.add("z=");

		int i = 0;
		while (i < len) {
			// 3개 검사가능
			if (i + 2 < len) {
				if (set.contains(String.valueOf(input, i, 3))) {
					result++;
					i += 3;
					continue;
				}
			}
			// 2개 검사가능 
			if (i + 1 < len) {
				if (set.contains(String.valueOf(input, i, 2))) {
					result++;
					i += 2;
					continue;
				}
			}
			// 한자리 문자만 남아있음
			result++;
			i++;
		}

		System.out.println(result);
	}
}