import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int H, W, N;
	static int[][] stickers;
	static int area;
	static int[] select = new int[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken()); // 모눈종이의 높이 1 ≤ H, W, N ≤ 100
		W = Integer.parseInt(st.nextToken()); // 모눈종이의 넓이
		N = Integer.parseInt(br.readLine()); // 스티커의 개수
		stickers = new int[N][2];
		for (int i = 0; i < N; i++) { // 스티커의 넓이 1 ≤ Ri, Ci ≤ 100
			st = new StringTokenizer(br.readLine());
			stickers[i][0] = Integer.parseInt(st.nextToken());
			stickers[i][1] = Integer.parseInt(st.nextToken());
		}

		// 풀이
		combs(0, 0);
		
		System.out.println(area);
	}
	
	static void check() {
		int tmpArea = 0;
		int w1 = stickers[select[0]][0];
		int w2 = stickers[select[1]][0];
		int h1 = stickers[select[0]][1];
		int h2 = stickers[select[1]][1];
		
		int bigW = Math.max(w1, w2);
		int bigH = Math.max(h1,h2);
		
		if (H >= h1+h2 && W>= bigW ||
				H >= h1+w2 && W >= Math.max(w1, h2) ||
				H >= bigH && W>= w1+w2 ||
				H >= Math.max(h1, w2) && W>=w1+h2 ||
				H >= Math.max(w1, h2) && W>=h1+w2 ||
				H >= bigW && W >= h1+h2 ||
				H >= w1 + h2 && W >= Math.max(h1, w2) ||
				H >= w1+w2 && W >= bigH) {
			tmpArea = w1*h1 + w2*h2;
		}
		
		area = Math.max(area, tmpArea);
	}

	static void combs(int srcIdx, int tgtIdx) {
		if (tgtIdx == 2) {
			check();
			return;
		}

		if (srcIdx == N)
			return;

		select[tgtIdx] = srcIdx; // 스티커 선택

		combs(srcIdx + 1, tgtIdx + 1);
		combs(srcIdx + 1, tgtIdx);

	}

}