import java.util.*;
import java.io.*;

public class Main {

	static int T, M, N, x, y;
	static StringBuilder sb = new StringBuilder();
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			flag = false;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			int doomsday = lcm(M, N); // 종말의 날
			int year = x;
			int nowY = x;

			while (year <= doomsday) {
				if (nowY > N) {
					if (nowY % N == 0)
						nowY = N;
					else
						nowY = nowY % N;
				}
				if (nowY == y) {
					sb.append(year).append("\n");
					flag = true;
					break;
				}
				year += M;
				nowY += M;
			}

			if (flag)
				continue;
			else
				sb.append(-1).append("\n");

		}

		System.out.println(sb);
	}

	static int lcm(int a, int b) {
		int big = Math.max(a, b);
		int small = big == a ? b : a;
		return a * b / gcd(big, small);
	}

	static int gcd(int a, int b) {
		if (a % b == 0)
			return b;
		else
			return gcd(b, a % b);
	}
}