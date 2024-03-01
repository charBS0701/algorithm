import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K;
	static int[] dx = { 1, -1, 2 };
	static boolean[] visit = new boolean[100_001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		bfs(N, K);

	}

	static void bfs(int start, int end) {
		if (start == end) {
			System.out.println(0);
			return;
		}
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { start, 0 });
		visit[start] = true;

		while (!que.isEmpty()) {
			int[] now = que.poll();
			for (int i = 0; i < 3; i++) {
				int nx = now[0];
				if (i == 2)
					nx *= 2;
				else
					nx += dx[i];

				if (nx == K) {
					System.out.println(now[1] + 1);
					return;
				}
					
				if (nx < 0 || nx >= 100_001 || visit[nx])
				    continue;

				que.offer(new int[] { nx, now[1] + 1 });
				visit[nx] = true;
			}
		}

	}
}
