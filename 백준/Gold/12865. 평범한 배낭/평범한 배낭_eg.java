package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_12865_평범한배낭_eg {
	static int N, K;
	static int[] weight;
	static int[] value;
	
	static int[][] memoi;	// 특정 물건, 특정 무게일 때 최대 가치를 저장
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		weight = new int[N+1];	// 0 dummy 라기보다는 0일 때 선택 없다
		value = new int[N+1];
		
		memoi = new int[N+1][K+1];		// 0 dummy 라기보다는 0일 때 선택 없다
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp
		// 모든 물건 고려(1 ~ N)
		for (int i = 1; i <= N; i++) {
			int w = weight[i];
			int v = value[i];
			// i 번 물건을 고려 1~K 까지의 무게를 채우는 데 최상의 선택 (value)
			// 최상의 선택시 이전에 고려한 물건 포함
			// 최상의 선택 2가지 구분 ( 현재 고려 i 물건 사용, 비사용 )
			for (int k = 1; k <= K; k++) {
				if ( w<=k) {
					// 현재 i 물건 사용, 비사용 2가지 중 더 높은 value 선택
					memoi[i][k] = Math.max(
							memoi[i-1][k],		// 비사용
							memoi[i-1][k-w] + v // 사용 
							);
				} else { // 현재 고려 i 물건 사용 X
					memoi[i][k] = memoi[i-1][k];	// 이전 물건까지 고려한 k 무게를 만족하는 최상의 value
				}
			}
		}
		
//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(memoi[i]));
//		}

/*    K : 0   1 2  3  4   5  6   7
6, 13		[0, 0, 0, 0, 0, 0, 13, 13]
4, 8		[0, 0, 0, 0, 8, 8, 13, 13]  4, 8 고려 비선택 13, 선택 이전 물건 무게 6에서 4뺀 2의 가치 0 + 8= 8
3, 6		[0, 0, 0, 6, 8, 8, 13, 14]  3, 6 고려 비선택 13, 선택 이전 물건 무게 7에서 3을 뺀 4의 가치 8 + 6 = 14
5, 12		[0, 0, 0, 6, 8, 12, 13, 14] 
*/
		
		System.out.println(memoi[N][K]);
	}
}
