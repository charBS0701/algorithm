import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] mat;
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());		
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			mat = new int[N][N];
			
			for (int i = 0; i < N; i++) {	// 파리 수 입
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max=0;
			
			
			for (int i = 0; i+M <= N ; i++) {
				for (int j = 0; j+M <= N; j++) {
					int tmp = 0;
					for (int k = 0; k < M; k++) {
						for (int k2 = 0; k2 < M; k2++) {
							tmp += mat[i+k][j+k2];
						}
					}
					max = Math.max(max, tmp);
				}
			}
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
	}

}

