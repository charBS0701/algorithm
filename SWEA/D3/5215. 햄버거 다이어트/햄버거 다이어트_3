package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// binary counting
public class 햄버거다이어트_3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static Item[] src;
	static int max; // 제한 칼로리를 넘지 않는 최고의 햄버거
	static int L;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수 1~20
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리 1~10,000

			src = new Item[N];

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				src[n] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 칼로리 1~1000
			}

			// 풀이
			max = 0;

			// 부분집합의 수
			int subsetCnt = 1 << N;
			// 0 ~ 31(32)
			// 펼쳐놓고 보면 i 의 의미가 바로 mask 역할
			for (int i = 0; i < subsetCnt; i++) {
				// 이미 모든 경우가 부분집합을 표현
				int cal = 0;
				int point = 0;

				for (int j = 0; j < N; j++) {
					if ((i & 1 << j) == 0)
						continue;
					cal += src[j].c;
					point += src[j].p;
				}
				// 조건에 맞는 max 갱신
				if (cal <= L)
					max = Math.max(max, point);
			}

			sb.append("#").append(t).append(" ").append(max).append("\n");

		}
		System.out.println(sb);
	}

	static class Item {
		int p, c;

		Item(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}

}
