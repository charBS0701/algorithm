import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 표의 크기 // 1 ≤ N ≤ 1024
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수 // 1 ≤ M ≤ 100,000

		// 수 입력
		int[][] arr = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {	//  줄 별로 구간합 구함
				arr[r][c] = Integer.parseInt(st.nextToken()) + arr[r][c-1];
			}
		}

		// 구간 입력
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int j1 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
			int j2 = Integer.parseInt(st.nextToken());
			
			int result = 0;
			for (int i = Math.min(i1, i2); i <= Math.max(i1, i2); i++) {
				result += arr[i][Math.max(j1, j2)] - arr[i][Math.min(j1, j2)-1];
			}
			
			sb.append(result + "\n");
		}

		System.out.println(sb);
	}

}
