import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int result;
	static boolean[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		list = new LinkedList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			result++;
			dfs(i);
		}
		System.out.println(result);
	}
	
	public static void dfs(int vertex) {
		if (list[vertex].isEmpty() || visited[vertex] == true) return;
		visited[vertex] = true;
		
		while (!list[vertex].isEmpty()) {
			dfs(list[vertex].remove(0));
		}
		
	}

}
