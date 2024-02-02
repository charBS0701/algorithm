import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식_eg {
  // 부분집합 이용

	static int N, min;
	static int[][] src;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	//  N(1 ≤ N ≤ 10)
		src = new int[N][2];
		select = new boolean[N];
		
		// 초기값
		min = Integer.MAX_VALUE;
		
		// 요리의 신맛과 쓴맛은 모두 1,000,000,000보다 작은 양의 정수
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[n][0] = Integer.parseInt(st.nextToken());
			src[n][1] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		System.out.println(min);
	}
	
	public static void subset(int srcIdx) {
		// 기저조건
		if (srcIdx == N) {
			// complete code
			// 현재 select 에 선택된 재료가 true 설정
			// 선택된 재료의 신맛합, 쓴맛합을 구해서 그 차이의 최소값 갱신
			// 재료 1개 이상
			int sin = 1;	// 곱하는 초기값
			int ssn = 0;	// 더하느 초기값
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					sin *= src[i][0];
					ssn += src[i][1];
					cnt++;
				}
			}
			
			if (cnt > 0) {	// 재료가 1개 이상이면
				min = Math.min(min, Math.abs(sin-ssn));
			}
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);
		
	}

}
