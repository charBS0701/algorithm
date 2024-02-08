package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs + prun
// Item -> int[2]

// 빠른 이유	#1 : 가지치기
//			#2 : 재귀호출하면서 sum을 재활용
public class 햄버거다이어트_4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] src;
	static int max; // 제한 칼로리를 넘지 않는 최고의 햄버거
	static int L;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수 1~20
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리 1~10,000
			src = new int[N][2];
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				src[n][0] = Integer.parseInt(st.nextToken());
				src[n][1] = Integer.parseInt(st.nextToken());
			}
			
			// 풀이
			max = 0;
			
			dfs(0,0,0);

			sb.append("#").append(t).append(" ").append(max).append("\n");

		}
		System.out.println(sb);
	}

	// select 배열에 의존 X
	// 매번 dfs() 재귀호출을 이어갈 때 필요한 계산 함께 해 간다.
	public static void dfs(int srcIdx, int point, int cal) {
		// 기저조건
		if ( srcIdx == N) {
			// complete code
			// if 조건이 없는 이유 : 재귀호출 할 때 가지치기로 처리
			max = Math.max(max, point);
			return;
		}
		
		// 비선택 : 현재 srcIdx 재료를 사용 X
		dfs(srcIdx + 1, point, cal);
		// 선택 : 가지치기 적용
		int nextCal = cal + src[srcIdx][1];	// 전달받은 cal + 현재료의 cal
		if (nextCal <= L) {
			dfs(srcIdx + 1, point + src[srcIdx][0], nextCal);
		}
	}
}
