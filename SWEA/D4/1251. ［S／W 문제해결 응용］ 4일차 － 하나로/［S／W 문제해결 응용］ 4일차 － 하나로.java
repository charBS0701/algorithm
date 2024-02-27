import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// MST - 쿠르스킬
public class Solution {

	static int T, N;
	static long ans;
	static int[][] island;
	static long[][] edges; // 간선 v1, v2, c(long)
	static double E; // 세율 <- 맨 마지막에 적용
	static int[] parent;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			island = new int[N][2]; // 0:x, 1:y
			// x 좌표
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i][0] = Integer.parseInt(st.nextToken());
			}
			// y 좌표
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i][1] = Integer.parseInt(st.nextToken());
			}
			// E
			E = Double.parseDouble(br.readLine());

			// 풀이
			// 간선 자료 구조 준비
			// 정점 4 <= 1:2,3,4 2:3,4 3:4 <= 4x3/2
			int size = N * (N - 1) / 2;
			edges = new long[size][3];
			int idx = 0;
			// 1:1 매칭을 위한 for
			for (int v1 = 0; v1 < N - 1; v1++) {
				for (int v2 = v1 + 1; v2 < N; v2++) {
					edges[idx][0] = v1;
					edges[idx][1] = v2;
					edges[idx][2] = distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]);
					idx++;
				}
			}

			parent = new int[N];
			makeSet();

			// 쿠르스칼
			Arrays.sort(edges, (o1, o2) -> Long.compare(o1[2], o2[2])); // long 형

			ans = 0;
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				int a = findSet((int) edges[i][0]);
				int b = findSet((int) edges[i][1]);
				if (a == b)
					continue;
				// 간선 선택
				if (a > b)
					parent[b] = a;
				else parent[a] = b;

				ans += edges[i][2]; // 거리 (비용) 추가
				cnt++;
				if (cnt == N - 1)
					break;
			}

			sb.append("#").append(t).append(" ").append(Math.round(ans * E)).append("\n");
		}
		System.out.println(sb);

	}

	static long distance(int x1, int x2, int y1, int y2) {
		return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	static void makeSet() {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = findSet(parent[x]);
	}
}
