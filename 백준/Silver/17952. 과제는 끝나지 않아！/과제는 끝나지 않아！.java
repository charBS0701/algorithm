import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int result; // 업무 평가 점수 예상
	static Deque<Task> stack = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 이번 분기 몇 분인지 (1 ≤ N ≤ 1,000,000)

		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int flag = Integer.parseInt(st.nextToken());
			if (flag == 1) {
				int A = Integer.parseInt(st.nextToken()); // 업무의 만점 // (1 ≤ A ≤ 100, 1 ≤ T ≤ 1,000,000)
				int T = Integer.parseInt(st.nextToken()); // 해결시간

				stack.push(new Task(A, T));
			}
			if (stack.isEmpty()) continue;
			
			stack.peek().takeTime--;
			if (stack.peek().takeTime == 0) {
				result += stack.pop().manjum;
			}

		}
		
		System.out.println(result);

	}

	static class Task {
		int manjum, takeTime;

		public Task(int manjum, int takeTime) {
			super();
			this.manjum = manjum;
			this.takeTime = takeTime;
		}

	}

}
