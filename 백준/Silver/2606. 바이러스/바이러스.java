import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int result;
	static boolean visit[];
	static List<List<Integer>> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 사람 수 
		K = Integer.parseInt(br.readLine());	// 연결 쌍의 수
		visit = new boolean[N+1];
		
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());	
			int e = Integer.parseInt(st.nextToken());
			list.get(s).add(e);
			list.get(e).add(s);
			
		}
		
		dfs(1);
		
		System.out.println(result);
	}
	
	static void dfs(int start) {
		visit[start] = true;
		
		for(int next : list.get(start)) {
			if (visit[next]) continue;
			visit[next] = true;
			result++;
			dfs(next);
		}
	}

}
