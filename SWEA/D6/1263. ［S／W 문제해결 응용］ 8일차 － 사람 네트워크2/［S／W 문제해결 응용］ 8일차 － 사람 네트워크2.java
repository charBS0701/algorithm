import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, ccMin;
	static int[][] mat;
	static int INF = 10000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			mat = new int[N][N];
			
			ccMin = INF;
			for (int i = 0; i < N * N; i++) {
				mat[i/N][i%N] = Integer.parseInt(st.nextToken()) == 0 ? INF : 1;
			}
			
			// 풀이
			fluid();	// 거리 구하기
			
			
			// cc 구하기
			for (int i = 0; i < N; i++) {
				int cc = 0;
				for (int j = 0; j < N; j++) {
					if (i==j) continue;
					cc += mat[i][j];
				}
				ccMin = Math.min(ccMin,cc);
			}
			
			sb.append("#").append(t).append(" ").append(ccMin).append("\n");
		}
		System.out.println(sb);
	}
	
	static void fluid() {
		for (int i = 0; i < N; i++) {		// 경유지
			for (int j = 0; j < N; j++) { 	// 출발지
				for (int j2 = 0; j2 < N; j2++) {	// 도착지
					int s2e = mat[j][j2];			// 기존 경로
					int s2m2e = mat[j][i] + mat[i][j2];	// 경유지를 거쳐간 경로
					mat[j][j2] = Math.min(s2e, s2m2e);	// 업데이트
				}
			}
		}
	}
}
