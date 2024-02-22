import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] pop; // 인구
	static List<Integer>[] A;
	static List<Integer> regionA, regionB;
	static int result = Integer.MAX_VALUE;
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		pop = new int[N + 1];
		visited = new boolean[N + 1];
		A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= N; i++) { // 인구입력
			pop[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) { // 연결상태입력
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int v = Integer.parseInt(st.nextToken());
				A[i].add(v);
//				A[v].add(i);	// 그 정점에서도 입력을 받기 때문에 안해도됨(안해야됨)
			}
		}

		// 선거구
		regionA = new ArrayList<>();
		regionB = new ArrayList<>();

		// 풀이
		// 1~N 번 도시 반복
		// 풀이
		dfs(1);


		System.out.println(result == Integer.MAX_VALUE ? -1 : result);

	}

	static void dfs(int start) {
	    if (start > N) {
	        if (!regionA.isEmpty() && !regionB.isEmpty() && isValid()) {
	            check();
	        }
	        return;
	    }

	    regionA.add(start);
	    dfs(start + 1);
	    regionA.remove(Integer.valueOf(start));

	    regionB.add(start);
	    dfs(start + 1);
	    regionB.remove(Integer.valueOf(start));
	}


	static boolean isValid() {
	    boolean[] visited = new boolean[N + 1];
	    Queue<Integer> queue = new ArrayDeque<>();

	    int start = regionA.get(0);
	    queue.add(start);
	    visited[start] = true;
	    while (!queue.isEmpty()) {
	        int x = queue.poll();
	        for (int y : A[x]) {
	            if (regionA.contains(y) && !visited[y]) {
	                visited[y] = true;
	                queue.add(y);
	            }
	        }
	    }
	    for (int x : regionA) {
	        if (!visited[x]) return false;
	    }

	    visited = new boolean[N + 1];
	    start = regionB.get(0);
	    queue.add(start);
	    visited[start] = true;
	    while (!queue.isEmpty()) {
	        int x = queue.poll();
	        for (int y : A[x]) {
	            if (regionB.contains(y) && !visited[y]) {
	                visited[y] = true;
	                queue.add(y);
	            }
	        }
	    }
	    for (int x : regionB) {
	        if (!visited[x]) return false;
	    }

	    return true;
	}

	static void check() { // 두 선거구의 차를 구해서 최솟값이면 업데이트
		int popA = 0, popB = 0;
		for (int i = 0; i < regionA.size(); i++) {
			popA += pop[regionA.get(i)];
		}
		for (int i = 0; i < regionB.size(); i++) {
			popB += pop[regionB.get(i)];
		}
		result = Math.min(result, Math.abs(popA - popB));
	}
}
