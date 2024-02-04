import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[] arr;
	static int N, M;
	static long count = 0;
	static long[] nCount;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 수의 개수 // (1 ≤ N ≤ 10^6, 2 ≤ M ≤ 10^3)
		M = Integer.parseInt(st.nextToken()); // 연속된 부분 구간의 합이 M으로 나누어 떨어지는지

		arr = new long[N];
		nCount = new long[M];

		st = new StringTokenizer(br.readLine());
		arr[0] = Long.parseLong(st.nextToken()); // (0 ≤ Ai ≤ 10^9)

		for (int i = 1; i < N; i++) { // 구간합 구하기 -> 1 3 6 7 9
			arr[i] = arr[i - 1] + Long.parseLong(st.nextToken()); // (0 ≤ Ai ≤ 10^9)
		}
		for (int i = 0; i < N; i++) { // 나머지 연산 -> 1 0 0 1 0
			arr[i] %= M;
			if (arr[i] == 0)
				count++;
			nCount[(int) arr[i]]++; // 갯수세기
		}

		for (int i = 0; i < M; i++) {
			if (nCount[i] > 1)
				count += nCount[i] * (nCount[i] - 1) / 2;
		}
		System.out.println(count);
	}
}
