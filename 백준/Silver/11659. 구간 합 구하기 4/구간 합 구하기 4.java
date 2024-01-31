import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 수 입력
		int[] arr = new int[N+1];
		int[] arrSum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		for (int n = 1; n <= N; n++) {
			arrSum[n] = arrSum[n-1] + arr[n];
		}
		
		// 구간 입력
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int result = arrSum[j] - arrSum[i-1];
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}

}
