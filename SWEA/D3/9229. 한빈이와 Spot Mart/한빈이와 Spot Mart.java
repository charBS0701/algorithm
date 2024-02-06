import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, M;	// (2 ≤ N ≤ 1000 , 2 ≤ M ≤ 2_000_000)
	static int[] snack;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());	// 테스트케이스 수
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 과자 수
			M = Integer.parseInt(st.nextToken());	// 최대 무게
			snack = new int[N];
			st = new StringTokenizer(br.readLine());			
			for (int n = 0; n < N; n++) {	// 과자 무게 입력
				snack[n] = Integer.parseInt(st.nextToken());
			}
			
			int result = -1;
			Arrays.sort(snack);
			for (int i = N-1; i >= 0; i--) {
				for (int j = N-2; j >=0 ; j--) {
					if (i==j) { // 같은 과자를 참조하지 않게
						continue;
					}
					int sum = snack[i]+snack[j];
					if (sum <= M && sum>result) {
						result = sum;
					}
					
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
