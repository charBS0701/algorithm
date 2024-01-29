import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 연산의 개수 N(1≤N≤100,000)
		
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			
			return abs1!=abs2 ? abs1-abs2 : (o1 > o2 ? 1 : -1);
			
		});
		
		
		// 수행
		for (int n = 0; n < N; n++) {
			int command = Integer.parseInt(br.readLine());

			if (command == 0) {		// 제거
				if (queue.isEmpty()) sb.append(0 + "\n");
				else sb.append(queue.poll() + "\n");
			} else {				// 추가
				queue.add(command);
			}
		}
		
		System.out.println(sb);

	}
}
