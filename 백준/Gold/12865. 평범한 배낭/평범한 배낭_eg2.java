package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_12865_평범한배낭_eg2 {
	static int N, K;
	static int[] weight;
	static int[] value;
	
	static int[] memoi;	// 특정 물건, 특정 무게일 때 최대 가치를 저장
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		weight = new int[N+1];	// 0 dummy 라기보다는 0일 때 선택 없다
		value = new int[N+1];
		
		memoi = new int[K+1];		// 0 dummy 라기보다는 0일 때 선택 없다
		
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
			
			for (int k = K; k >= w; k--) {
				memoi[k] = Math.max(
						memoi[k],	// 원 배열 그대로(이전 상태)	// 비선택
						memoi[k - w] + v // 선택
						);
			}
//			System.out.println(Arrays.toString(memoi));
		}
/*
[0, 0, 0, 0, 0, 0, 13, 13]
[0, 0, 0, 0, 8, 8, 13, 13]
[0, 0, 0, 6, 8, 8, 13, 14]
[0, 0, 0, 6, 8, 12, 13, 14]
 */
		
		System.out.println(memoi[K]);
	}
}
