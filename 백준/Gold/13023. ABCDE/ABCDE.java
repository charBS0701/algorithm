import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	
	static int N,M;
	static List<Integer>[] A;
	static boolean visited[];
	static int count=1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
			A[b].add(a);
		}
		
		for (int i = 0; i < N; i++) {
			dfs(i,count);
			if (count==5) break;
		}
		
		System.out.println(count==5 ? 1 : 0);
	}
	
	static void dfs(int start, int depth) {
		visited[start] = true;
		if (depth == 5) {
			count = depth;
			return;
		}
		
		for(int next : A[start]) {
			if (visited[next]) continue;
			dfs(next, depth+1);
		}
		visited[start] = false;
	}
}
