import java.io.*;
import java.util.*;

public class Solution {
	static int T, N, A, sum;
	static PriorityQueue<Integer> pqMin = new PriorityQueue<>();
	static PriorityQueue<Integer> pqMax = new PriorityQueue<>((o1, o2) -> o2 - o1);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sum = 0;
			pqMin.clear();
			pqMax.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			pqMin.offer(A);
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				// 힙에 추가
				pqMax.offer(Math.min(x, y));
				pqMin.offer(Math.max(x, y));

				while (pqMax.peek() > pqMin.peek()) {
					int tmp = pqMax.poll();
					pqMax.offer(pqMin.poll());
					pqMin.offer(tmp);
				}

				// 중간값 더하기
				sum = (pqMin.peek() + sum) % 20171109;
			}
			sb.append("#").append(t).append(" ").append(sum % 20171109).append("\n");
		}
		System.out.println(sb);
	}
}
