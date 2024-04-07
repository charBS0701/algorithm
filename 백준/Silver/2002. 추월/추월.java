// 2002 추월
// https://www.acmicpc.net/problem/2002

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Main {
	static int N; // 1~100
	static int result;
	static Queue<String> que = new ArrayDeque<>();
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			que.offer(br.readLine());
		}
		String tmp = "";
		String input = "";
		int count = 0;
		while(!que.isEmpty() && count < N) {
			if (input.equals("")) {				// 나오는 차 
				input = br.readLine();
				count++;
			}
			
			if (tmp.equals("")) {
				tmp = que.poll();				// 나올거라 예상되는 차
			}
			
			if (set.contains(tmp)) {			// 이미 지나간 차
				tmp = "";
				continue;	
			}
			
			if (input.equals(tmp)) {
				set.add(tmp);
				tmp = "";
				input = "";
			} else {	// 예상된 차가 안나오면
				set.add(input);
				input = "";
				result++;
			}
		}
		
		System.out.println(result);
	}
}
