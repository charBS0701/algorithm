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
			for (int c = 1; c <= N; c++) {	//  왼쪽으로 사각형으로의 누적합을 구하며 입력
				arr[r][c] = -arr[r - 1][c - 1] + arr[r - 1][c] + arr[r][c - 1] + Integer.parseInt(st.nextToken());
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
			
			// 뺴고 빼고 겹친 부분 더하고
			int result = arr[Math.max(i1, i2)][Math.max(j1, j2)];
			result -= arr[Math.max(i1, i2)][Math.min(j1, j2) - 1];
			result -= arr[Math.min(i1, i2) - 1][Math.max(j1, j2)];
			result += arr[Math.min(i1, i2) - 1][Math.min(j1, j2) - 1];
			sb.append(result + "\n");
		}

		System.out.println(sb);
	}

}
