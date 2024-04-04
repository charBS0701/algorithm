// 17276_배열돌리기
// https://www.acmicpc.net/problem/17276

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int T, n, d;
	static boolean minus;
	static int[][] map, newMap;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			minus = d > 0 ? false : true;
			d = Math.abs(d/45); // 45도로 돌릴 횟수
			map = new int[n + 1][n + 1];
			newMap = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i <= n; i++) {
				newMap[i] = Arrays.copyOf(map[i], n + 1);
			}

			// 풀이
			for (int k = 0; k < d; k++) { // 돌리기 반복
				int center = (n + 1) / 2;
				for (int i = 1; i <= n - center; i++) { // 껍질 수
					if (!minus) {
						newMap[center - i][center - i] = map[center][center - i]; // 위왼쪽
						newMap[center - i][center] = map[center - i][center - i]; // 위중간
						newMap[center - i][center + i] = map[center - i][center]; // 위오른

						newMap[center][center + i] = map[center - i][center + i]; // 중오른
						newMap[center + i][center + i] = map[center][center + i]; // 밑오른

						newMap[center + i][center] = map[center + i][center + i]; // 밑중간
						newMap[center + i][center - i] = map[center + i][center]; // 밑왼쪽

						newMap[center][center - i] = map[center + i][center - i]; // 중왼쪽
					} else { // 반시계 회전
						newMap[center - i][center - i] = map[center - i][center]; // 위왼쪽
						newMap[center - i][center] = map[center - i][center + i]; // 위중간
						newMap[center - i][center + i] = map[center][center + i]; // 위오른

						newMap[center][center + i] = map[center + i][center + i]; // 중오른
						newMap[center + i][center + i] = map[center + i][center]; // 밑오른

						newMap[center + i][center] = map[center + i][center - i]; // 밑중간
						newMap[center + i][center - i] = map[center][center - i]; // 밑왼쪽

						newMap[center][center - i] = map[center - i][center - i]; // 중왼쪽
					}
				}

				for (int i = 0; i <= n; i++) {
					map[i] = Arrays.copyOf(newMap[i], n + 1);
				}

			}


			// 출력
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}
}