import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;	// 정점의 개수 1~100
	static boolean[][] mat;
	static boolean[] visit;
	static boolean[][] result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		mat = new boolean[N][N];
		result = new boolean[N][N];
		for (int i = 0; i < N; i++) {	// 인접행렬
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				mat[i][j] = st.nextToken().equals("0") ? false : true; 
			}
		}
		
		// 풀이
		for (int i = 0; i < N; i++) {
			visit = new boolean[N];
			dfs(i);
			
			for (int j = 0; j < N; j++) {
				if (visit[j]) {
					result[i][j] = true;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j] ? "1" : "0").append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(int start) {
		for (int i = 0; i < N; i++) {
			if (!visit[i] && mat[start][i] == true) {
				visit[i] = true;
				dfs(i);
			}
		}
	}
	
}
