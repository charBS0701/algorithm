import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] bags;
	static int[][] dp = new int[101][100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N(1 ≤ N ≤ 100)
		K = Integer.parseInt(st.nextToken()); // K(1 ≤ K ≤ 100,000)
		bags = new int[N][2];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			bags[n][0] = w;
			bags[n][1] = v;
		}
		
		// 풀이
		System.out.println(solve(0,0));

	}
	
	static int solve(int idx, int weight) {
		if (dp[idx][weight] > 0) return dp[idx][weight];
		if (idx==N) return 0;
		
		int n1 = 0;
		if (weight + bags[idx][0] <= K)
			n1 = bags[idx][1] + solve(idx+1, weight + bags[idx][0]);	// 포함
		int n2 = solve(idx+1, weight);
		return dp[idx][weight] = Math.max(n1, n2);
	}


}