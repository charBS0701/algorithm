import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] nums;
	static boolean[] visited;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // (1 ≤ M ≤ N ≤ 8)
		M = sc.nextInt();
		nums = new int[N];
		visited = new boolean[N];
		result = new int[M];
		
		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}

		// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 // nPm
		perm(0);
		System.out.println(sb);

	}

	public static void perm(int idx) {
		if (idx == M) {
			for (int n : result) {
				sb.append(n + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			else {
				result[idx] = nums[i];
				visited[i] = true;
				perm(idx + 1);
				visited[i] = false;
			}
		}

	}

}