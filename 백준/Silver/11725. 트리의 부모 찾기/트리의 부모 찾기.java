import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] parent;
	static List<List<Integer>> gra = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i <= N; i++) {
			gra.add(new ArrayList<Integer>());
		}

		parent = new int[N + 1];

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			gra.get(a).add(b);
			gra.get(b).add(a);

		}

		bfs(1);

		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append("\n");
		}

		System.out.println(sb);
	}

	public static void bfs(int start) {
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(start);

		while (!que.isEmpty()) {
			int now = que.poll();

			for (int next : gra.get(now)) {
				if (parent[next] != 0)
					continue;
				parent[next] = now;
				que.offer(next);
			}
		}

	}

}
