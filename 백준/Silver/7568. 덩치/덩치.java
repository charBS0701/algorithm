// 7568 덩치
// https://www.acmicpc.net/problem/7568

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N; // 2 ≤ N ≤ 50
	static List<Dungchi> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			list.add(new Dungchi(w, h));
		}

		// 풀이
		for (int i = 0; i < N; i++) {
			int rank = 1;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (list.get(i).compareTo(list.get(j)) == 1)
					rank++;
			}
			sb.append(rank).append(" ");
		}

		System.out.println(sb);
	}

	static class Dungchi implements Comparable<Dungchi> {
		int weight, height;

		public Dungchi(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}

		@Override
		public int compareTo(Dungchi o) {
			if (this.weight < o.weight && this.height < o.height) { // 나보다 덩치큰 놈이 오면 return 1
				return 1;
			}
			else return 0;
		}
	}

}
