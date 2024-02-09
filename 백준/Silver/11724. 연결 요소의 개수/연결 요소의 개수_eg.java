package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수_2 {

	static ArrayList<Integer>[] A;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		A = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			A[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			A[s].add(e); // 양방향 에지이므로 양쪽에 에지를 더하기
			A[s].add(s);
		}
		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) { // 방문하지 않은 노드가 없을 떄까지 반복하기
				count++;
				DFS(i);
			}
		}
		System.out.println(count);

	}

	static void DFS(int v) {
		if (visited[v]) {
			return;
		}
		visited[v] = true;
		for (int i : A[v]) {
			if (visited[i] == false)
				DFS(i);
			;
		}
	}
}
