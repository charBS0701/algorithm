// 5567 결혼식
// https://www.acmicpc.net/problem/5567

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, result; // 2~500, 1~10000
	static List<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visit = new boolean[N + 1];
		for (int n = 0; n <= N; n++) {
			graph.add(new ArrayList<>());
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph.get(s).add(e);
			graph.get(e).add(s);
		}

		bfs(1, 0);

		System.out.println(result);
	}

	static void bfs(int start, int depth) {
		Deque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { start, depth });
		visit[start] = true;

		while (!que.isEmpty()) {
			int[] now = que.poll();
			for (int next : graph.get(now[0])) {
				if (visit[next])
					continue;
				visit[next] = true;
				if (now[1] <= 1) {
					que.offer(new int[] { next, now[1] + 1 });
					result++; // 초대
				}
			}
		}
	}

}