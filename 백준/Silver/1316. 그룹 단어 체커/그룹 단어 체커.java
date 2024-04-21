// 1316 그룹 단어 체커
// https://www.acmicpc.net/problem/1316

import java.io.*;
import java.util.*;

public class Main {

	static int N, result;
	static boolean flag = true;
	static boolean[] visit = new boolean[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			char[] word = br.readLine().toCharArray();
			Arrays.fill(visit, false);
			flag = true;
			
			visit[word[0]-'a'] = true;
			for (int i = 1; i < word.length; i++) {
				char c = word[i];
				if (visit[c-'a']) {
					if (word[i-1] == c) continue;
					else {
						flag = false;
						break;
					}
				} else {
					visit[word[i]-'a'] = true;
				}
			}
			
			if (flag) result++;
		}
		
		System.out.println(result);
	}
}
