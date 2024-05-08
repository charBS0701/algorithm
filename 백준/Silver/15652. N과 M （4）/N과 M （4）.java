import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] src, tgt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		src = new int[N];
		tgt = new int[M];
		
		for (int n = 1; n <= N; n++) {
			src[n-1] = n;
		}
		
		solve(0);
		
		System.out.println(sb);
	}
	
	static void solve(int tgtIdx) {
		if (tgtIdx == M) {		// 기저조건
			for (int m = 0; m < M; m++) {
				sb.append(tgt[m]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (tgtIdx > 0 && tgt[tgtIdx-1] > src[i]) continue;  // N과M(3) 에서 추가된 코드
			tgt[tgtIdx] = src[i];
			solve(tgtIdx+1);
		}
		
	}
}