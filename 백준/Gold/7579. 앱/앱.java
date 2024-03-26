import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[] m, c;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 앱 수
        int M = Integer.parseInt(st.nextToken()); // 필요한 메모리 
        int[] memory = new int[N];
        int[] cost = new int[N];
        int sumCost = 0; 
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sumCost += cost[i];
        }
        
        int[] dp = new int[sumCost + 1];
        int result = sumCost; // 최소 비용
        
        for (int i = 0; i < N; i++) {
            for (int j = sumCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
                if (dp[j] >= M) {
                    result = Math.min(result, j);
                }
            }
        }
        
        System.out.println(result);
    }
}
