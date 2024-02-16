import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int arr[];
	static int tgt[];
	static boolean visited[];
	static List<int[]> res;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = new ArrayList<>();
		arr = new int[N];
		tgt = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		// 순열
		perm(0);

		for (int[] tmp : res) {
			for (int i = 0; i < M; i++) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void perm(int tgtIdx) {
		// 기저조건
		if (tgtIdx == M) {
			boolean flag = true;
			int[] copy = Arrays.copyOf(tgt, M);	// 만든 배열을 복사
			for (int[] tmp : res) {				// 리스트에 같은 배열이 없다면 
				if (Arrays.equals(tmp, copy)) {
					flag = false;
					break;
				}
			}
			if (flag) res.add(copy);			// 추가
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			tgt[tgtIdx] = arr[i];
			visited[i] = true;
			perm(tgtIdx + 1);
			visited[i] = false;
		}

	}
}
