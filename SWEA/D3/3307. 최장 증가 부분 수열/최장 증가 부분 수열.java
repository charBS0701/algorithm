import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	
	static int T, N, len;
	static int[] input;
	static int[] LIS;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			LIS = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			// 풀이
			len = 0;
			
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;  // 최소 길이 1로 설정
				
				for (int j = 0; j < i; j++) {	 // 맨 앞에서 (현재 i 이전)
					if (input[j] < input[i] && LIS[j] >= LIS[i] ) LIS[i] = LIS[j] + 1;
				}
				
				// max 값 갱신
				len = Math.max(len, LIS[i]);
			}
			
			sb.append("#").append(t).append(" ").append(len).append("\n");
		}
		System.out.println(sb);
	}

}
