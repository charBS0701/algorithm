// 10815 숫자 카드
// https://www.acmicpc.net/problem/10815

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			if (set.contains(Integer.parseInt(st.nextToken()))) sb.append(1);
			else sb.append(0);
			sb.append(" ");
		}
		
		System.out.println(sb);
		
	}

}