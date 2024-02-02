import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식_eg3 {
  // binary counting
	static int N, min;
	static int[][] src;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	//  N(1 ≤ N ≤ 10)
		src = new int[N][2];
		
		// 초기값
		min = Integer.MAX_VALUE;
		
		// 요리의 신맛과 쓴맛은 모두 1,000,000,000보다 작은 양의 정수
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[n][0] = Integer.parseInt(st.nextToken());
			src[n][1] = Integer.parseInt(st.nextToken());
		}
		
		// 풀이
		int subsetCnt = 1 << src.length;
		
		for (int i = 1; i < subsetCnt; i++) {	// 재료가 최소 1개이상... 맨앞은 재료 0개이므로 skip
			int sin = 1;	// 곱하는 초기값
			int ssn = 0;	// 더하느 초기값
			
			for (int j = 0; j < N; j++) {	// 원소 하나씩 확인
				if ( ( i & (1 << j)) != 0) {
					sin *= src[j][0];
					ssn += src[j][1];
				}
			}
			min = Math.min(min,  Math.abs(sin-ssn));
		}
		System.out.println(min);
	}
	

}
