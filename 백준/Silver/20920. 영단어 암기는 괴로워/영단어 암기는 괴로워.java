import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static Map<String, Integer> map = new HashMap<>();
	static List<List<String>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			if (str.length() < M)
				continue;
			map.put(str, map.getOrDefault(str, 0) + 1);

			int times = map.get(str);
			if (times != 1) {
				list.get(times - 1).remove(str);
			}
			list.get(times).add(str);
		}

		for (int i = N; i >= 1; i--) {
			if (list.get(i).isEmpty()) continue;
			list.get(i).sort((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length());
			for (String res : list.get(i)) {
				sb.append(res).append("\n");
			}
		}

		System.out.println(sb);

	}
}