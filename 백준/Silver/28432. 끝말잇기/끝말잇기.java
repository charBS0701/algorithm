// 28432 끝말잇기
// https://www.acmicpc.net/problem/28432

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int N, M, idx;
	static String[] arr1, arr2;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr1 = new String[N];
		for (int n = 0; n < N; n++) {
			String s = br.readLine();
			arr1[n] = s;
			set.add(s);
			if (s.equals("?"))
				idx = n;
		}
		M = Integer.parseInt(br.readLine());
		arr2 = new String[M];
		for (int m = 0; m < M; m++) {
			arr2[m] = br.readLine();
		}

		char pre = 'n', post = 'n';
		if (idx != 0)
			pre = arr1[idx - 1].charAt(arr1[idx - 1].length() - 1);
		if (idx != N - 1)
			post = arr1[idx + 1].charAt(0);

		for (int i = 0; i < M; i++) {
			String m = arr2[i];
			if (!set.contains(m) && (m.charAt(0) == pre || pre == 'n')
					&& (m.charAt(m.length() - 1) == post || post == 'n')) {
				System.out.println(m);
				return;
			}
		}
	}
}