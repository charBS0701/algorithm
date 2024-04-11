// 2615 오목
// https://www.acmicpc.net/problem/2615

import java.io.*;
import java.util.*;

public class Main {

	static int[][] map = new int[20][20];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 풀이
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				// 가로체크
				{
					boolean blackFlag = true;
					boolean whiteFlag = true;
					int ny = i, nx = j;
					for (int k = 0; k < 5; k++) {
						nx = j + k;
						if (!isValid(ny, nx) || map[ny][nx] != 1) {
							blackFlag = false;
						}
						if (!isValid(ny, nx) || map[ny][nx] != 2) {
							whiteFlag = false;
						}
					}
					// 6목 체크
					if (isValid(ny, nx + 1) && map[ny][nx + 1] == 1)
						blackFlag = false;
					if (isValid(i, j - 1) && map[i][j - 1] == 1)
						blackFlag = false;

					if (isValid(ny, nx + 1) && map[ny][nx + 1] == 2)
						whiteFlag = false;
					if (isValid(i, j - 1) && map[i][j - 1] == 2)
						whiteFlag = false;

					if (blackFlag) {
						System.out.println(1);
						System.out.println(i + " " + j);
						return;
					} else if (whiteFlag) {
						System.out.println(2);
						System.out.println(i + " " + j);
						return;
					}
				}

				// 세로체크
				{
					boolean blackFlag = true;
					boolean whiteFlag = true;
					int ny = i, nx = j;
					for (int k = 0; k < 5; k++) {
						ny = i + k;
						if (!isValid(ny, nx) || map[ny][nx] != 1) {
							blackFlag = false;
						}
						if (!isValid(ny, nx) || map[ny][nx] != 2) {
							whiteFlag = false;
						}
					}

					// 6목 체크
					if (isValid(ny + 1, nx) && map[ny + 1][nx] == 1)
						blackFlag = false;
					if (isValid(i - 1, j) && map[i - 1][j] == 1)
						blackFlag = false;

					if (isValid(ny + 1, nx) && map[ny + 1][nx] == 2)
						whiteFlag = false;
					if (isValid(i - 1, j) && map[i - 1][j] == 2)
						whiteFlag = false;

					if (blackFlag) {
						System.out.println(1);
						System.out.println(i + " " + j);
						return;
					} else if (whiteFlag) {
						System.out.println(2);
						System.out.println(i + " " + j);
						return;
					}
				}

				// 우하향 대각선 체크
				{
					boolean blackFlag = true;
					boolean whiteFlag = true;
					int ny = i, nx = j;
					for (int k = 0; k < 5; k++) {
						ny = i + k;
						nx = j + k;
						if (!isValid(ny, nx) || map[ny][nx] != 1) {
							blackFlag = false;
						}
						if (!isValid(ny, nx) || map[ny][nx] != 2) {
							whiteFlag = false;
						}
					}

					// 6목 체크
					if (isValid(ny + 1, nx + 1) && map[ny + 1][nx + 1] == 1)
						blackFlag = false;
					if (isValid(i - 1, j - 1) && map[i - 1][j - 1] == 1)
						blackFlag = false;

					if (isValid(ny + 1, nx + 1) && map[ny + 1][nx + 1] == 2)
						whiteFlag = false;
					if (isValid(i - 1, j - 1) && map[i - 1][j - 1] == 2)
						whiteFlag = false;

					if (blackFlag) {
						System.out.println(1);
						System.out.println(i + " " + j);
						return;
					} else if (whiteFlag) {
						System.out.println(2);
						System.out.println(i + " " + j);
						return;
					}
				}

				// 우상향 대각선 체크
				{
					boolean blackFlag = true;
					boolean whiteFlag = true;
					int ny = i, nx = j;
					for (int k = 0; k < 5; k++) {
						ny = i - k;
						nx = j + k;
						if (!isValid(ny, nx) || map[ny][nx] != 1) {
							blackFlag = false;
						}
						if (!isValid(ny, nx) || map[ny][nx] != 2) {
							whiteFlag = false;
						}
					}

					// 6목 체크
					if (isValid(ny - 1, nx + 1) && map[ny - 1][nx + 1] == 1)
						blackFlag = false;
					if (isValid(i + 1, j - 1) && map[i + 1][j - 1] == 1)
						blackFlag = false;

					if (isValid(ny - 1, nx + 1) && map[ny - 1][nx + 1] == 2)
						whiteFlag = false;
					if (isValid(i + 1, j - 1) && map[i + 1][j - 1] == 2)
						whiteFlag = false;

					if (blackFlag) {
						System.out.println(1);
						System.out.println(i + " " + j);
						return;
					} else if (whiteFlag) {
						System.out.println(2);
						System.out.println(i + " " + j);
						return;
					}
				}
			}
		}
		System.out.println(0);

	}

	static boolean isValid(int y, int x) {
		if (y <= 0 || x <= 0 || x > 19 || y > 19)
			return false;
		else
			return true;
	}
}