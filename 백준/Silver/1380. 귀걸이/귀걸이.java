import java.io.*;
import java.util.*;

public class Main {

	static int N, t;
	static StringBuilder sb = new StringBuilder();
	static String[] girls;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			girls = new String[N];
			visit = new boolean[N];
			for (int i = 0; i < N; i++) {
				girls[i] = br.readLine();
			}
			for (int i = 0; i < N * 2 - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken()) - 1;
				visit[num] = visit[num] == false ? true : false;
			}

			for (int i = 0; i < N; i++) {
				if (visit[i] == true) {
					sb.append(++t).append(" ").append(girls[i]).append("\n");
					break;
				}
			}

		}

		System.out.println(sb);

	}
}