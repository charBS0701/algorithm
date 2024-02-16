import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T, N, halfN, min;
	static int[][] map;
	static boolean[] select;	// 반만 선택된
	static int[] arrA, arrB;	// 각각 선택된 index, 선택되지 않은 index
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			halfN = N/2;
			map = new int[N][N];
			select = new boolean[N];
			
			arrA = new int[halfN];
			arrB = new int[halfN];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 풀이
			min = Integer.MAX_VALUE;
			
			comb(0,0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		// 기저조건 : 반만 선택 
		if (tgtIdx == halfN) {
			check();
			return;
		}
		
		if(srcIdx == N) return;
		
		select[srcIdx] = true;		// 별도의 tgt 배열에 담는게 아니라, select 에 표시만
		comb(srcIdx+1, tgtIdx+1);	// 선택 O
		select[srcIdx] = false;		// target 에 담을 때는 이거 안해도 됨, 지금은 select 에 표시하는거니까 해야함 
		comb(srcIdx +1, tgtIdx);	// 선택 X
		
	}
	
	static void check() {
		int sumA = 0;
		int sumB = 0;
		
		// select[] 를 보고 arrA, arrB 분리 작업
		int idxA = 0;
		int idxB = 0;
		
		for (int i = 0; i < N; i++) {
			if (select[i]) arrA[idxA++] = i;
			else arrB[idxB++] = i;
		}
		
		// 8개 select : f f t f t t t f
		// 			   0 1 2 3 4 5 6 7
		// arrA 	: 2 4 5 6 
		// arrB 	: 0 1 3 7
		for (int i = 0; i < halfN; i++) {
			for (int j = 0; j < halfN; j++) {
				if (i==j) continue;		// 같은 재료는 skip
				sumA += map[arrA[i]][arrA[j]];
				sumB += map[arrB[i]][arrB[j]];
			}
		}
		
		min = Math.min(min, Math.abs(sumA-sumB));
		
	}
	
}

