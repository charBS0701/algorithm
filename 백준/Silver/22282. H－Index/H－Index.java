// 22282 H-Index
// https://www.acmicpc.net/problem/22282

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Integer[] arr;
	static int H;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Integer[N];
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr, Collections.reverseOrder());

		int count = 0;
		int need = arr[0];

		int idx = 0;
		for (int i = need; i >= 0; i--) {
			if (idx < N) {
				if (arr[idx] >= i) {
					count++;
					idx++;
				}
			}

			if (count >= i) {
				H = i;
				break;
			}
		}

		System.out.println(H);
	}

}
