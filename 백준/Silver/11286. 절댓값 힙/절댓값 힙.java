import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> pq = new PriorityQueue<>( // 절댓값이 작은순서, 같으면 음수우선
			(o1, o2) -> {
				return Math.abs(o1) == Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2);
			});

	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (pq.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(pq.poll()).append("\n");
				
			} else {
				pq.offer(input);
			}
		}

		System.out.println(sb);
	}

}
