import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int arr[];
	static int idx1 = 0;
	static int idx2 = 1;
	static int result = 0;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine()); // 재료의 개수 1~15,000
		M = Integer.parseInt(br.readLine()); // 완성 요건 1~10,000,000
		arr = new int[N];

		// 재료 고유번호 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (i == j)
					continue;
				if (arr[i] + arr[j] == M)
					result++;
			}
		}

		System.out.println(result);

	}

}
