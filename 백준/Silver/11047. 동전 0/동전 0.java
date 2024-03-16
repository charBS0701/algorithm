import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int coins[];
	static int now, count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		now = K = Integer.parseInt(st.nextToken());
		coins = new int[N];
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			coins[i] = n;
		}
		
		for (int i = N-1; i >= 0; i--) {
			if (coins[i] > now) continue;
			count += now/coins[i]; 
			now -= now/coins[i] * coins[i];
			
			if(now==0) break;
		}
		
		System.out.println(count);
		
	}

}
