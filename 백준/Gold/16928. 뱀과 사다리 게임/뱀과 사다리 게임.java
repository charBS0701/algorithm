import java.io.*;
import java.util.*;

public class Main {

	static int N, M; // 사다리 수, 뱀 수
	static int[] visit = new int[101];
	static int[] portal = new int[101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Arrays.fill(visit, -1);

		for (int n = 0; n < N; n++) { // 사다리 정보
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			portal[x] = y;
		}

		for (int m = 0; m < M; m++) { // 뱀의 정보
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			portal[u] = v;
		}

		bfs();
		System.out.println(visit[100]);

	}

	static void bfs() {
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { 1, 0 }); // 위치, 주사위굴린 횟수
		visit[1] = 0;

		while (!que.isEmpty()) {
			int[] now = que.poll();
			for (int d = 1; d <= 6; d++) {
				int next = now[0] + d;
				if (!isValid(next)) continue;
				while (portal[next] != 0) {
					next = portal[next]; 
				}
				if (visit[next] == -1 || visit[next] > now[1] + 1) {
					visit[next] = now[1] + 1;
					que.offer(new int[] {next, now[1]+1});
				}
			}
		}
	}
	
	static boolean isValid(int num) {
		if (num > 100) return false;
		else return true;
	}
}