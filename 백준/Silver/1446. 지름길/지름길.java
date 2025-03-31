import java.io.*;
import java.util.*;

public class Main
{
    static int N, D;
    static List<List<int[]>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for (int d=0; d<=D; d++) {
		    list.add(new ArrayList<>());
		}
		
		for (int n=0; n<N; n++) {
		    st = new StringTokenizer(br.readLine());
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    int d = Integer.parseInt(st.nextToken());
		    
		    if (e > D || d >= e-s) continue;
		    
		    list.get(s).add(new int[]{s,e,d});
		}
		
		int[] dp = new int[D+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i=0; i<=D; i++) {
		    if (i>0) dp[i] = Math.min(dp[i], dp[i-1] + 1);
		    
		    for (int[] now : list.get(i)) {
		        if (dp[now[1]] > dp[i] + now[2]) {
		            dp[now[1]] = dp[i] + now[2];
		        }
		    }
		}
		
		System.out.println(dp[D]);
		
	}
}