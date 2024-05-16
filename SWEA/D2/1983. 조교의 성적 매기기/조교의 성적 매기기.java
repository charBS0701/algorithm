import java.util.*;
import java.io.*;

public class Solution {
	static int T, N, K; // N 은 항상 10의 배수
	static int a, b, c;
	static int num; // 동점자 수
	static int[] scores;
	static String result;
	static String grade[] = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) { // 학생 수, 학점 알고싶은 애 K
			pq.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			num = N / 10;
			scores = new int[N + 1];
			for (int n = 1; n <= N; n++) { // 중간, 기말, 과제 점수
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				scores[n] = a * 35 + b * 45 + c * 20;
				pq.offer(scores[n]);
			}
			int k = 0;
			while(true) {
				if (scores[K] == pq.poll()) {
					result = grade[k/num];
					break;
				}
				k++;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");

		}

		System.out.println(sb);
	}
}
