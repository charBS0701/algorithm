// 18111 마인크래프트
// https://www.acmicpc.net/problem/18111

import java.io.*;
import java.util.*;

public class Main {

	static int N, M, B; // 세로, 가로, 인벤토리
	static int[][] map;
	static int top, bottom = 256;
	static int minTime = Integer.MAX_VALUE, resultHeight;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				top = Math.max(top, map[n][m]);
				bottom = Math.min(bottom, map[n][m]);
			}
		}

		while (top >= bottom) {
			int copyB = B;
			int time = 0;

			for (int n = 0; n < N; n++) {	// 평탄화 작업 
				for (int m = 0; m < M; m++) {
					int height = map[n][m];
					int gap = Math.abs(height - top);
					if (height > top) { // 파내기
						copyB += gap;
						time += gap * 2;
					} else if (height < top) {
						copyB -= gap;
						time += gap;
					}
				}
			}

			if (copyB >= 0) { // 가능한 경우일 때
				if (minTime > time) {
					minTime = time;
					resultHeight = top;
				}
			}

			top--;
		}

		// 시간, 땅의 높이
		System.out.println(minTime + " " + resultHeight);
	}
}