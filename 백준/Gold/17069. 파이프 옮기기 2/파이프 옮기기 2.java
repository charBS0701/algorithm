import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static long dp[][][]; // 방향, y, x

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		dp = new long[3][N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		dp[1][1][2] = 1; // 시작점
		for (int i = 1; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				// 대각선
				if (i < N && j < N && map[i+1][j+1] == 0 && map[i][j+1] == 0 && map[i+1][j]==0) {
					dp[0][i+1][j+1] += (dp[0][i][j] + dp[1][i][j] + dp[2][i][j]);
				}
				// 가로
				if (j < N && map[i][j+1] == 0) {
					dp[1][i][j+1] += (dp[0][i][j] + dp[1][i][j]);
				}
				// 세로
				if (i< N && map[i+1][j] == 0) {
					dp[2][i+1][j] += (dp[0][i][j] + dp[2][i][j]);
				}
				
			}
		}
		
		
		System.out.println(dp[0][N][N]+dp[1][N][N]+dp[2][N][N]);

	}

}
