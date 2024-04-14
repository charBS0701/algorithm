// 1236 성지키기
// https://www.acmicpc.net/problem/1236

import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static int result = Integer.MAX_VALUE;
	static char[][] map;
	static boolean[] rCheck;
	static boolean[] cCheck;
	static int rCnt, cCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		rCheck = new boolean[R];
		cCheck = new boolean[C];

		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'X') {
					rCheck[r] = true;
					cCheck[c] = true;
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			if (rCheck[i]) rCnt++;
		}
		for (int i = 0; i < C; i++) {
			if (cCheck[i]) cCnt++;
		}
		
		System.out.println(Math.max(R-rCnt, C-cCnt));
		
	}
}
