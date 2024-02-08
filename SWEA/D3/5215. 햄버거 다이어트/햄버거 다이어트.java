import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static Item[] src;
	static boolean[] select;
	static int max; // 제한 칼로리를 넘지 않는 최고의 햄버거
	static int L;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수 1~20
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리 1~10,000
			max = 0;
			src = new Item[N];
			select = new boolean[N];
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				src[n] = new Item( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) ); // 칼로리 1~1000
			}
			
			// 풀이
			subset(0);

			sb.append("#").append(t).append(" ").append(max).append("\n");

		}
		System.out.println(sb);
	}

	public static void subset(int srcIdx) {
		// 기저조건
		if ( srcIdx == N) {
			// complete code
			// 부분집합의 한 경우가 완성
			int cal = 0;
			int point = 0;
			
			for (int i = 0; i < N; i++) {
				if ( ! select[i]) continue;
				cal += src[i].c;
				point += src[i].p;
			}
			// 조건에 맞는 max 갱신
			if (cal <= L) max = Math.max(max, point);
			return;
		}
		
		select[srcIdx] = true;	// 선택
		subset(srcIdx + 1);
		select[srcIdx] = false;	// 비선택
		subset(srcIdx + 1);
	}
	
	static class Item {
		int p, c;
		Item(int p, int c) {
			this.p = p; this.c = c;
		}
	}

}
