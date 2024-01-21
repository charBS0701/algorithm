import java.util.*;
public class Main {

	static int count = 0;	// 바이러스 옮은 컴퓨터 수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 컴퓨터의 수	// 1<= <= 100
		int M = sc.nextInt();	// 직접연결돼 있는 컴퓨터의 쌍 수

		
		// 인접행렬
		int[][] mat = new int[N+1][N+1];
		int[] visited = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			mat[i][i]=1;
		}
		
		for (int m = 0; m < M; m++) {	// 연결돼 있는 쌍 입력
			int from = sc.nextInt();
			int to = sc.nextInt();
			mat[from][to] = 1;
			mat[to][from] = 1;
		}
		
		dfs(1, mat, visited);
		
		System.out.println(count-1);	// 1제외
		
	}
	public static void dfs(int node, int[][] mat, int[] visited) {
		for (int i = 1; i < visited.length; i++) {
			if (mat[node][i] == 1 && visited[i] != 1) {
				count++;
				visited[i] = 1;
				dfs(i, mat, visited);
			}
		}
	}
	
}