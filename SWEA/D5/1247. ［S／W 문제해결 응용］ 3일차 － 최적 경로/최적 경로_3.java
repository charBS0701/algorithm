package graph.copy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 완탐 - dfs - 가지치기
public class SW_최적경로_3 {
	static int T, N, comY, comX, homeY, homeX, min;
	static int[][] cust;
	static boolean[] visit; // == select in perm
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			min = Integer.MAX_VALUE;

			N = Integer.parseInt(br.readLine());
			; // 고객수

			cust = new int[N][2];
			visit = new boolean[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			comY = Integer.parseInt(st.nextToken());
			comX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}

			// 회사로부터 출발하되, 각 고객별로 시작 고객을 선택해서 각각의 경우에 대해 dfs
			// - 회사에서 고객 0 번부터 방문해보고, 고객 1번부터 방문해보고.....
			for (int i = 0; i < N; i++) {

				Arrays.fill(visit, false);
				visit[i] = true;
				dfs(i, 1, distance(comY, comX, cust[i][0], cust[i][1]));
			}

			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	// c : customer
	// d : depth
	// sum : sum
	static void dfs(int c, int d, int sum) {

		if (d == N) {

			sum += distance(homeY, homeX, cust[c][0], cust[c][1]);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < N; i++) {

			if (visit[i])
				continue;

			int dis = distance(cust[c][0], cust[c][1], cust[i][0], cust[i][1]);
			if (sum + dis >= min)
				continue; // 가지치기

			visit[i] = true;
			dfs(i, d + 1, sum + dis);
			visit[i] = false;
		}
	}

	static int distance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1 - y2) + Math.abs(x1 - x2);
	}
}
