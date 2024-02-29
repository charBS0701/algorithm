import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 어느 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로
// 
public class Main {
	static int N; // (2 ≤ N ≤ 10)
	static int[][] mat;
	static int[] src;
	static int[] tgt;
	static boolean[] select;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		src = new int[N];
		select = new boolean[N];
		for (int i = 0; i < N; i++) {
			src[i] = i + 1;
		}
		tgt = new int[N];
		mat = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		perm(0);

		System.out.println(min);
	}

	static void perm(int tgtIdx) {
		if (tgtIdx == tgt.length) {
			int sum = 0;
			for (int i = 1; i < tgtIdx; i++) {
				sum += mat[tgt[i - 1]][tgt[i]];
				if (mat[tgt[i - 1]][tgt[i]] == 0) return;
			}
			if (mat[tgt[tgt.length-1]][tgt[0]]==0) return;
			sum += mat[tgt[tgt.length-1]][tgt[0]];
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < src.length; i++) {
			if (select[i])
				continue;
			tgt[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}

	}

}
