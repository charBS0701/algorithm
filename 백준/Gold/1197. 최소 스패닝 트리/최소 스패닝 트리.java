import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, result;
	static boolean[] visit;
	static List<List<int[]>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		visit = new boolean[V + 1];
		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(s).add(new int[] { e, w });
            list.get(e).add(new int[] { s, w });
		}

		// 풀이
		prim(1);
		System.out.println(result);

	}

	static void prim(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]); // 가중치작은순
		pq.addAll(list.get(start));
		visit[start] = true;
		int count = 0;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (visit[now[0]])
				continue;
			visit[now[0]] = true;
			result += now[1];
			count++;
			if( count == V-1) break;
			for (int[] next : list.get(now[0])) {
				if (!visit[next[0]])
					pq.add(next);
			}

		}

	}
}
