// 9375 패션왕 신해빈
// https://www.acmicpc.net/problem/9375

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int T, N; // n: 0~30
	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			int result = 1;
			map.clear();
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				map.put(type, map.getOrDefault(type, 0)+1);
			}
			Set<String> set = map.keySet();
			
			for (String s : set) {
				result *= map.get(s)+1;
			}
			sb.append(result-1).append("\n");
		}
		
		System.out.println(sb);
	}

}