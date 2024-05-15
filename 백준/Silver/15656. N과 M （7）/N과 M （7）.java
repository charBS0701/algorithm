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
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			src[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(src);
		
		solve(0,0);
		
		System.out.println(sb);
		
	}
	
	static void solve(int srcIdx, int tgtIdx) {
		if (tgtIdx == M) {
			for(int num : tgt) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = srcIdx; i < N; i++) {
			tgt[tgtIdx] = src[i];
			solve(srcIdx, tgtIdx+1);
		}
		
	}
}