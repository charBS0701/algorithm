// 16953 A -> B
// https://www.acmicpc.net/problem/16953

import java.io.*;
import java.util.*;

public class Main {
	static int A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		if (!bfs(A)) System.out.println(-1);
	}

	static boolean bfs(int start) {
		Queue<long[]> que = new ArrayDeque<>();
		que.offer(new long[] { start, 0 });

		while (!que.isEmpty()) {
			long[] now = que.poll();

			// 2 곱하기
			long next = now[0] * 2;
			long nextCnt = now[1] + 1;
			if (next < B) {
				que.offer(new long[] { next, nextCnt });
			} else if (next == B) {
				System.out.println(nextCnt+1);
				return true;
			}

			// 1 붙이기
			next = now[0] * 10 + 1;
			if (next < B) {
				que.offer(new long[] { next, nextCnt });
			} else if (next == B) {
				System.out.println(nextCnt+1);
				return true;
			}

		}
		return false;
	}

}
