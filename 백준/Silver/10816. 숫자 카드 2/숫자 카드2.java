// using HashMap

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Map<Integer,Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			Integer num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			Integer key = Integer.parseInt(st.nextToken());
			Integer result = map.get(key);
			if (result==null) sb.append(0 + " ");
			else sb.append(map.get(key) + " ");
		}
		System.out.println(sb.toString());
	}
}
