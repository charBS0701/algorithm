import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<Dot> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Dot(y, x));

		}

		Collections.sort(list, (o1, o2) -> o1.y == o2.y ? o1.x - o2.x : o1.y - o2.y);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			Dot now = list.get(i);
			sb.append(now.x).append(" ").append(now.y).append("\n");
		}

		System.out.println(sb);
	}

	static class Dot {
		int y, x;

		Dot(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
