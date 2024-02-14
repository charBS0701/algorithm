import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N; // 1 ≤ N ≤ 1,000,000
	static int[] res; // 10^9 ≤ Xi ≤ 10^9 (int 가능)
	static int rank;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Queue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		res = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			que.add(new int[] { i, Integer.parseInt(st.nextToken()) });
		}

		int[] now = que.poll();
		res[now[0]] = rank;
		int[] prev = now;

		while (!que.isEmpty()) {
			now = que.poll();
			if (now[1] == prev[1]) {
				res[now[0]] = rank;
			} else {
				res[now[0]] = ++rank;
			}
			prev = now;
		}

		StringBuilder sb = new StringBuilder();
		for (int i : res) {
			sb.append(i).append(" ");
		}

		System.out.println(sb);

	}
}
