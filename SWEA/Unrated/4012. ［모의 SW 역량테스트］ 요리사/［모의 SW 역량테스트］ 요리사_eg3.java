package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_요리사_4012_eg3 {
	// comb + np
	static int T, N, halfN, min;
	static int[][] map;
	static boolean[] select; // 반만 선택된
	static int[] arrA, arrB; // 각각 선택된 index, 선택되지 않은 index
	static StringBuilder sb = new StringBuilder();

	/// 000111 ~~> 111000
	static int[] index;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			halfN = N / 2;
			map = new int[N][N];

			index = new int[N];
			for (int i = halfN; i < N; i++) {
				index[i] = 1;
			}

			arrA = new int[halfN];
			arrB = new int[halfN];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 풀이
			min = Integer.MAX_VALUE;

			while (true) {
				check();
				if (!np(index))
					break;
			}
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void check() {
		int sumA = 0;
		int sumB = 0;

		// select[] 를 보고 arrA, arrB 분리 작업
		int idxA = 0;
		int idxB = 0;

		for (int i = 0; i < N; i++) {
			if ( index[i] == 1)
				arrA[idxA++] = i;
			else
				arrB[idxB++] = i;
		}

		// 8개 select : f f t f t t t f
		// 0 1 2 3 4 5 6 7
		// arrA : 2 4 5 6
		// arrB : 0 1 3 7
		for (int i = 0; i < halfN; i++) {
			for (int j = 0; j < halfN; j++) {
				if (i == j)
					continue; // 같은 재료는 skip
				sumA += map[arrA[i]][arrA[j]];
				sumB += map[arrB[i]][arrB[j]];
			}
		}

		min = Math.min(min, Math.abs(sumA - sumB));

	}

	static boolean np(int[] array) {
		int i, j, k;
		i = j = k = array.length - 1;

		while (i > 0 && array[i - 1] >= array[i])
			i--;

		if (i == 0)
			return false;

		while (array[i - 1] >= array[j])
			j--;
		swap(array, i - 1, j);

		while (i < k) {
			swap(array, i++, k--);
		}

		return true;
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
