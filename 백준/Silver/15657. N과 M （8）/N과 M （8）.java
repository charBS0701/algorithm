import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] tgt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		tgt = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 풀이
		Arrays.sort(arr);
		comb(0,0);
		System.out.println(sb);
	}

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(tgt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

        for (int i = srcIdx; i < N; i++) {
        	tgt[tgtIdx] = arr[i];
            comb(i, tgtIdx + 1);
        }

	}
}
