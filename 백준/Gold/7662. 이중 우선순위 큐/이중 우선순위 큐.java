import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int T, k, count;
	static PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
	static PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			pq1.clear(); // 초기화
			pq2.clear(); // 초기화
			map.clear(); // 초기화
			count = 0;	 // 초기화
			k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char c = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				int tmp = 0;
				if (c == 'I') {
					count++;
					pq1.offer(num);
					pq2.offer(num);
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else if (c == 'D') {
					if (count==0) continue;
					count--;
					if (num == 1) {
						while(true) {
							tmp = pq1.poll();
							if (map.get(tmp) != 0) {
								break;
							}
						}
						map.put(tmp, map.get(tmp)-1);
						
					} else if (num == -1) {
						while(true) {
							tmp = pq2.poll();
							if (map.get(tmp) != 0) {
								break;
							}
						}
						map.put(tmp, map.get(tmp)-1);
					}
				}
			}
			if (count==0)
				sb.append("EMPTY");
			else {
				while (true) {
					int res = pq1.poll();
					if (map.get(res) == 0) continue;
					sb.append(res).append(" ");
					break;
				}
				while (true) {
					int res = pq2.poll();
					if (map.get(res) == 0) continue;
					sb.append(res);
					break;
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}