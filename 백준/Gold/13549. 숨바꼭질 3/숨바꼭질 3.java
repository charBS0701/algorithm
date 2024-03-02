import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static boolean visit[] = new boolean[100_001];

	static int[] dx = { 1, -1, 2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		System.out.println(bfs(N));

	}

	static int bfs(int start) {
		if (N == K)
			return 0;

		Deque<int[]> que = new ArrayDeque<>();
		que.add(new int[] { start, 0 });
		visit[start] = true;

		while (!que.isEmpty()) {
			int[] now = que.poll();
			for (int d = 2; d >= 0; d--) {
				int nx = now[0];
				if (d != 2) {
					nx += dx[d];
				} else {
					nx *= 2;
				}

				if (nx < 0 || nx > 100_000 || visit[nx]) // 범위보호
					continue;
				else if (nx == K) { // 찾았다
					if (d != 2) {
						return now[1] + 1;
					} else {
						return now[1];
					}
				}

				visit[nx] = true;
				if (d != 2)
					que.addLast(new int[] { nx, now[1] + 1 });
				else
					que.addFirst(new int[] { nx, now[1] });
			}
		}

		return 0;

	}

}
