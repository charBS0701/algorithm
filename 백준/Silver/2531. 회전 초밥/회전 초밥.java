import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, d, k, c;
	static List<Integer> sushi = new LinkedList<>();
	static int[] visit = new int[3001]; // 초밥의 종류 1~3000
	static int result;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥 가짓 수
		k = Integer.parseInt(st.nextToken()); // 연속먹는 접시 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		for (int n = 0; n < N; n++) {
			int next = Integer.parseInt(br.readLine());
			sushi.add(next);
		}

		for (int i = 0; i < k; i++) {
			int now = sushi.get(i);
			visit[now]++;
			if (visit[now] == 1)
				result++;
		}
		if (visit[c] == 0)
			result++;
		max = Math.max(max, result);
		if (visit[c] == 0)
			result--;

		for (int i = 0; i < N - 1; i++) {
			int idx = i + k;
			if (i + k >= N)
				idx %= N;
			int next = sushi.get(idx);
			visit[next]++;
			if (visit[next] == 1)
				result++;
			visit[sushi.get(i)]--;
			if (visit[sushi.get(i)] == 0)
				result--;

			if (visit[c] == 0)
				result++;
			max = Math.max(max, result);
			if (visit[c] == 0)
				result--;
		}

		System.out.println(max);

	}

}