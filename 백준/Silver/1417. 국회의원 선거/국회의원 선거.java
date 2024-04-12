// 1417 국회의원 선거
// https://www.acmicpc.net/problem/1417

import java.io.*;
import java.util.*;

public class Main {
	static int N; // N <= 50, 득표수 100이하
	static int result;
	static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int dasom = Integer.parseInt(br.readLine());
		for (int n = 0; n < N - 1; n++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		while (!pq.isEmpty() && dasom <= pq.peek()) {
			int top = pq.poll();
			result++;
			dasom++;
			pq.add(top-1);
		}

		System.out.println(result);

	}
}