// 10815 숫자 카드
// https://www.acmicpc.net/problem/10815

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, count;
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
			
		for (int n = 0; n < N; n++) {
			set.add(br.readLine());
		}
		
		for (int m = 0; m < M; m++) {
			if (set.contains(br.readLine())) count++;
		}
		
		System.out.println(count);
	}

}