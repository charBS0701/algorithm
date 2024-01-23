import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 연산의 개수	// N(1 ≤ N ≤ 100,000)
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		for (int n = 0; n < N; n++) {
			int command = Integer.parseInt(br.readLine());
			if (command == 0) {		// 배열에서 가장 작은 수 출력, 제거
				if (heap.isEmpty()) {	// 배열이 비었다면
					System.out.println(0);
				} else {	// 최솟값 출력, 제거
					System.out.println(heap.poll());
				}
			} else {	// 2^31 보다 작은 자연수
				heap.add(command);
			}	
		}
	}
}
