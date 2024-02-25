import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;
	static int[] distance;
	static ArrayList<Edge>[] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine()); // (2 ≤ V ≤ 100,000)
		A = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			A[i] = new ArrayList<Edge>();
		}
		for (int i = 1; i <= V; i++) { 		// A 인접리스트에 그래프 데이터 저장하기
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 정점 번호

			while (st.hasMoreTokens()) { // 자손, 거리 입력
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == -1)
					break;
				A[s].add(new Edge(tmp, Integer.parseInt(st.nextToken())));
			}
		}
		distance = new int[V + 1];
		visited = new boolean[V + 1];
		BFS(1);
		int Max = 1;
		for (int i = 2; i <= V; i++) { // distance 배열에서 가장 큰 값으로 다시 시작점 설정
			if (distance[Max] < distance[i])
				Max = i;

		}
		distance = new int[V + 1];
		visited = new boolean[V + 1];
		BFS(Max);	// 새로운 시작점으로 실행
		Arrays.sort(distance);
		System.out.println(distance[V]);

	}

	public static void BFS(int index) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(index);
		visited[index] = true;
		while (!que.isEmpty()) {
			int now_node = que.poll();
			for (Edge i : A[now_node]) {
				int e = i.e;
				int v = i.value;
				if (!visited[e]) {
					visited[e] = true;
					que.add(e);
					distance[e] = distance[now_node] + v; // 거리 배열 업데이트하기
				}
			}
		}

	}

}

class Edge {
	int e;
	int value;
	
	public Edge(int e, int value) {
		this.e = e;
		this.value = value;
	}
}